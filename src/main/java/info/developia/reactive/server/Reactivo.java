package info.developia.reactive.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Reactivo {
    private static final Logger log = Logger.getLogger(Reactivo.class.getName());

    private final HttpServer httpServer;
    private final int port;
    private boolean virtualThreads = true;
    private int threadsInPool = 200;
    private String status;

    private Reactivo(HttpServer httpServer, int port) {
        this.httpServer = httpServer;
        this.port = port;
    }

    public static Reactivo init() throws IOException {
        return initOn(8888);
    }

    public static Reactivo initOn(int port) throws IOException {
        var httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        return new Reactivo(httpServer, port);
    }

    public void start() {
        httpServer.setExecutor(getExecutor(virtualThreads));
        httpServer.start();
        log.info("Server started on %s".formatted(port));
    }

    public Reactivo addRoute(String path, RequestHandler handler) {
        httpServer.createContext(path, handler);
        return this;
    }

    private Executor getExecutor(boolean virtualThreads) {
        if (virtualThreads) {
            return Executors.newVirtualThreadPerTaskExecutor();
        } else {
            return Executors.newFixedThreadPool(threadsInPool);
        }
    }

    public Reactivo virtualThreads(boolean virtualThreadsActive) {
        virtualThreads = virtualThreadsActive;
        return this;
    }

    public Reactivo threadPool(int threadsInPool) {
        this.threadsInPool = threadsInPool;
        return this;
    }
}
