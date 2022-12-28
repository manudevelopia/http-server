package info.developia.reactive.server;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static info.developia.reactive.server.Method.GET;

public class RequestHandler {
    private final List<RouteHandler> routeHandlers = new ArrayList<>();

    public void get(BiConsumer<Request, Response> handler) {
        routeHandlers.add(new RouteHandler(GET, handler));
    }

    public void get(String path, BiConsumer<Request, Response> handler) {
        routeHandlers.add(new RouteHandler(GET, path, handler));
    }

    public List<RouteHandler> routeHandlers() {
        return routeHandlers;
    }
}
