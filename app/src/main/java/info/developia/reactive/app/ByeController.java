package info.developia.reactive.app;

import info.developia.reactive.server.RequestHandler;

public class ByeController extends RequestHandler {

    public ByeController() {
        get((request, response) -> {
            System.out.printf("Adios %s %n", request);
        });

        get("/bye", (request, response) -> {
            System.out.printf("Bye bye %n", request);
        });
    }
}
