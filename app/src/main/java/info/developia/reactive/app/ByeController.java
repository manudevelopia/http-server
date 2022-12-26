package info.developia.reactive.app;

import info.developia.reactive.server.RequestHandler;

public class ByeController extends RequestHandler {

    public ByeController() {
        get("/bye", (request, response) -> {
            System.out.printf("Adios %s %n", request);
        });
    }
}
