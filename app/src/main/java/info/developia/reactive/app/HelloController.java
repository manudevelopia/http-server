package info.developia.reactive.app;

import info.developia.reactive.server.Handler;

public class HelloController extends Handler {

    public HelloController() {
        get((request, response) -> {
            String body = "Hello %s ".formatted(request);
            response.body("%s - %s %s".formatted(request, response, body));
        });

        get("/me", (request, response) -> {
            String body = "Hello me %s ".formatted(request);
            response.body("%s - %s %s".formatted(request, response, body));
        });

        get("/say/:name", (request, response) -> {
            String body = "Hello say/:name %s".formatted(request);
            response.body("%s - %s %s".formatted(request, response, body));
        });
    }
}
