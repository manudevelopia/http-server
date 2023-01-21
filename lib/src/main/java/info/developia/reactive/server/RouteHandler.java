package info.developia.reactive.server;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class RouteHandler implements Comparable<RouteHandler> {
    private final Method method;
    private String pathPattern;
    private final List<String> pathVariables;
    private final BiConsumer<Request, Response> handler;

    public RouteHandler(Method method, BiConsumer<Request, Response> handler) {
        this(method, "", handler);
    }

    public RouteHandler(Method method, String pathPattern, BiConsumer<Request, Response> handler) {
        this.method = method;
        this.pathPattern = pathPattern;
        this.handler = handler;
        this.pathVariables = getPathVariables(pathPattern);
    }

    private List<String> getPathVariables(String pathPattern) {
        return Arrays.stream(pathPattern.split("/"))
                .filter(pathPart -> pathPart.startsWith(":"))
                .map(pathPart -> pathPart.substring(1))
                .toList();
    }

    public Method method() {
        return method;
    }

    public void basePath(String basePath) {
        this.pathPattern = basePath + pathPattern;
    }

    public String pathPattern() {
        return pathPattern;
    }

    public boolean hasPathVariables() {
        return pathVariables.size() > 0;
    }

    public List<String> getPathVariables() {
        return pathVariables;
    }

    public BiConsumer<Request, Response> handler() {
        return handler;
    }

    @Override
    public int compareTo(RouteHandler otherRouteHandler) {
        int possition = method().compareTo(otherRouteHandler.method());
        if (possition != 0) {
            return possition;
        }
        possition = pathPattern.compareTo(otherRouteHandler.pathPattern());
        return possition;
    }
}
