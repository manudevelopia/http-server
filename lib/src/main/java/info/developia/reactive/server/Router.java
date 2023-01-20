package info.developia.reactive.server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {
    private final Map<String, BiConsumer<Request, Response>> staticRoutes = new HashMap<>();

    public void map(String basePath, Handler handler) {
        handler.routeHandlers().forEach((routeHandler) -> {
            staticRoutes.put(routeHandler.method() + basePath + routeHandler.pathPattern(), routeHandler.handler());
        });
    }

    public BiConsumer<Request, Response> getHandler(String handlerKey) {
        return staticRoutes.getOrDefault(handlerKey, (req, res) -> {
            res.status(404);
            res.body("not found!!!");
        });
    }
}
