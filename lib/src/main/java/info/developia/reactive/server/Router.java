package info.developia.reactive.server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {
    private final Map<String, BiConsumer<Request, Response>> routes = new HashMap<>();

    public void map(String basePath, RequestHandler handler) {
        handler.handlers().forEach((path, pathHandler) -> routes.put(basePath + path, pathHandler));
    }

    public BiConsumer<Request, Response> getHandler() {
        return routes.entrySet().stream().findFirst().get().getValue();
    }
}
