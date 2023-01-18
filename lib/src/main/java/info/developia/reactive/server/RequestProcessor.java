package info.developia.reactive.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

import static info.developia.util.value.Value.valueOr;

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

        t.sendResponseHeaders(response.status(), response.body().length());
        OutputStream os = t.getResponseBody();
        os.write(response.body().getBytes());
        os.close();
    }

    private Request buildRequest(HttpExchange t) {
        try {
            return new Request(
                    t.getRequestMethod(),
                    t.getRequestURI().getPath(),
                    valueOr(t.getRequestURI().getQuery(), ""),
                    t.getRequestHeaders().getFirst("Content-Type"),
                    new String(t.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private BiConsumer<Request, Response> getHandler(Request request) {
        return router.getHandler(request.method() + request.path());
    }
}
