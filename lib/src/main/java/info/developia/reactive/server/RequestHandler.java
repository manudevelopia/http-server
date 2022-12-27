package info.developia.reactive.server;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static info.developia.reactive.server.Method.GET;

public class RequestHandler {
    private final List<Route> routes = new ArrayList<>();

    public void get(BiConsumer<Request, Response> handler) {
        routes.add(new Route(GET, handler));
    }

    public void get(String path, BiConsumer<Request, Response> handler) {
        routes.add(new Route(GET, path, handler));
    }

    public List<Route> routes() {
        return routes;
    }
}
