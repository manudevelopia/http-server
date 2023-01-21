package info.developia.reactive.server;

import info.developia.util.structure.tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {
    private final Map<String, BiConsumer<Request, Response>> staticRoutes = new HashMap<>();
    private final BinaryTree<RouteHandler> routes = new BinaryTree<>(RouteHandler::compareTo);

    public void map(String basePath, Handler handler) {
        handler.routeHandlers().forEach((routeHandler) -> {
            routeHandler.basePath(basePath);
            staticRoutes.put(routeHandler.method() + basePath + routeHandler.pathPattern(), routeHandler.handler());
            routes.add(routeHandler);
        });
    }

    public BiConsumer<Request, Response> getHandler(String handlerKey) {
        return staticRoutes.getOrDefault(handlerKey, (req, res) -> {
            res.status(404);
            res.body("not found!!!");
        });
    }
}
