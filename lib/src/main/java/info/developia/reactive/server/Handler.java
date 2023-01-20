package info.developia.reactive.server;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static info.developia.reactive.server.Method.GET;

public abstract class Handler {
    private final List<RouteHandler> routeHandlers = new ArrayList<>();

    protected void get(BiConsumer<Request, Response> handler) {
        routeHandlers.add(new RouteHandler(GET, handler));
    }

    protected void get(String path, BiConsumer<Request, Response> handler) {
        routeHandlers.add(new RouteHandler(GET, path, handler));
    }

    List<RouteHandler> routeHandlers() {
        return routeHandlers;
    }
}
