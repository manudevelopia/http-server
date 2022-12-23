package info.developia.reactive.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class RequestHandler implements HttpHandler {

    Map<String, BiConsumer<String, String>> handlers = new HashMap<>();

    void get(String path, BiConsumer<String, String> handler) {
        handlers.put("GET" + path, handler);
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "%s - %s".formatted(t.getRequestMethod(), t.getRequestURI().getPath());

        getHandler(t).accept("request", response);

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private BiConsumer<String, String> getHandler(HttpExchange t) {
        return handlers.get(t.getRequestMethod() + t.getRequestURI().getPath());
    }
}
