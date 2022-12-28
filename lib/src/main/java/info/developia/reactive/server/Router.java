package info.developia.reactive.server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {
    private final Map<String, BiConsumer<Request, Response>> routes = new HashMap<>();

    public void map(String basePath, RequestHandler handler) {
        handler.routeHandlers().forEach((route) -> routes.put(route.method() + basePath + route.pathPattern(), route.handler()));
    }

    public BiConsumer<Request, Response> getHandler(String handlerKey) {
        return routes.computeIfAbsent(handlerKey, (e) -> (req, res) -> {
            res.status(404);
            res.body("not found!!!");
        });
    }
}
