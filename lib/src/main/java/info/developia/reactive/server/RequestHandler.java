package info.developia.reactive.server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class RequestHandler {
    private final Map<String, BiConsumer<Request, Response>> handlers = new HashMap<>();

    public void get(BiConsumer<Request, Response> handler) {
        handlers.put("GET" + "/", handler);
    }

    public void get(String path, BiConsumer<Request, Response> handler) {
        handlers.put("GET" + path, handler);
    }

    public Map<String, BiConsumer<Request, Response>> handlers() {
        return handlers;
    }
}
