package info.developia.reactive.server;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Route {
    private final Method method;
    private final String pathPattern;
    private final List<String> pathVariables;
    private final BiConsumer<Request, Response> handler;

    public Route(Method method, BiConsumer<Request, Response> handler) {
        this(method, "", handler);
    }

    public Route(Method method, String pathPattern, BiConsumer<Request, Response> handler) {
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
}
