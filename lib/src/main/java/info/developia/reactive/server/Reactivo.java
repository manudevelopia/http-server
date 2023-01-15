package info.developia.reactive.server;

import ratpack.core.server.RatpackServer;

import java.util.logging.Logger;

public class Reactivo {
    private static final Logger log = Logger.getLogger(Reactivo.class.getName());
    private final int port;
    private final Router router;

    private Reactivo(int port) {
        this.port = port;
        this.router = new Router();
    }

    public static Reactivo init() {
        try {
            return initOn(8888);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static Reactivo initOn(int port) {
        return new Reactivo(port);
    }

    public void start() {
        try {
            RatpackServer.start(server -> server.handlers(router.handlers()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Server started on %s port".formatted(port));
    }

    public Reactivo addHandler(String basePath, RequestHandler handler) {
        router.map(basePath, handler);
        return this;
    }
}
