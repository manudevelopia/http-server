package info.developia.reactive.server;

import java.util.function.BiConsumer;


public class RequestHandler {
    private BiConsumer<Request, Response> handler;

    protected void get(BiConsumer<Request, Response> handler) {
        get("/", handler);
    }

    protected void get(String path, BiConsumer<Request, Response> handler) {
        this.handler = handler;
    }

    public BiConsumer<Request, Response> getHandler() {
        return handler;
    }
}
