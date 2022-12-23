package info.developia.reactive.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Reactivo {
    private static boolean virtualThreads = true;
    private static int port = 8080;
    private static HttpServer httpServer;

    public static void init() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        httpServer.setExecutor(getExecutor(virtualThreads));
    }

    public static void start() {
        httpServer.start();
    }

    public static void addRoute(String path, RequestHandler handler) {
        httpServer.createContext(path, handler);
    }

    private static Executor getExecutor(boolean virtualThreads) {
        if (virtualThreads) {
            return Executors.newVirtualThreadPerTaskExecutor();
        } else {
            return Executors.newFixedThreadPool(200);
        }
    }
}
