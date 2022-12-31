package info.developia.reactive.app;

import info.developia.reactive.server.RequestHandler;

public class ByeController extends RequestHandler {

    public ByeController() {
        get( (request, response) -> {
            String body = "Adios a secas %s".formatted(request);
            response.body("%s - %s %s".formatted(request, response, body));
        });
        get("/bye", (request, response) -> {
            String body = "Adios adios %s".formatted(request);
            response.body("%s - %s %s".formatted(request, response, body));
        });
    }
}
