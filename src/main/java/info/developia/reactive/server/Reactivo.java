package info.developia.reactive.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Reactivo {
    private final HttpServer httpServer;
    private boolean virtualThreads = true;
    private int threadsInPool = 200;

    private Reactivo(HttpServer httpServer) {
        this.httpServer = httpServer;
    }

    public static Reactivo init() throws IOException {
        return initOn(8888);
    }

    public static Reactivo initOn(int port) throws IOException {
        var httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        return new Reactivo(httpServer);
    }

    public void start() {
        httpServer.setExecutor(getExecutor(virtualThreads));
        httpServer.start();
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
