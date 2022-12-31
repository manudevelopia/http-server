package info.developia.reactive.server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {
    private final Map<String, BiConsumer<Request, Response>> staticRoutes = new HashMap<>();
    private final Map<String, BiConsumer<Request, Response>> parametricRoutes = new HashMap<>();

    public void map(String basePath, RequestHandler handler) {
        handler.routeHandlers().forEach((routeHandler) -> {
            if (routeHandler.hasPathVariables()) {
                parametricRoutes.put(routeHandler.method() + basePath + routeHandler.pathPattern(), routeHandler.handler());
            } else {
                staticRoutes.put(routeHandler.method() + basePath + routeHandler.pathPattern(), routeHandler.handler());
            }
        });
    }

    public BiConsumer<Request, Response> getHandler(String handlerKey) {
        if(staticRoutes.containsKey(handlerKey)){
            return staticRoutes.get(handlerKey);
        }

        checkParametric(handlerKey);

        return staticRoutes.computeIfAbsent(handlerKey, (e) -> (req, res) -> {
            res.status(404);
            res.body("not found!!!");
        });
    }

    private void checkParametric(String handlerKey) {
        String[] requestUrlParts = handlerKey.split("/");
        parametricRoutes.entrySet().stream()
                .filter(route-> route.getKey().startsWith(requestUrlParts[0]))
    }
}
