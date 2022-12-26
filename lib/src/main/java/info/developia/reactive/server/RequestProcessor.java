package info.developia.reactive.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

public class RequestProcessor implements HttpHandler {
    private final Router router;

    protected RequestProcessor(Router router) {
        this.router = router;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        var request = buildRequest(t);
        var response = new Response();

        getHandler(request).accept(request, response);
        response.setBody("%s - %s".formatted(request, response));

        t.sendResponseHeaders(response.getStatus(), response.getBody().length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBody().getBytes());
        os.close();
    }

    private Request buildRequest(HttpExchange t) {
        try {
            return new Request(t.getRequestMethod(), t.getRequestURI().getPath(), t.getRequestURI().getQuery(),
                    new String(t.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private BiConsumer<Request, Response> getHandler(Request request) {
//        return handlers.get(t.getRequestMethod() + t.getRequestURI().getPath());
        return router.getHandler();
    }
}
