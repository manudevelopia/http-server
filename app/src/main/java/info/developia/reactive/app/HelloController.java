package info.developia.reactive.app;

import info.developia.reactive.server.RequestHandler;

public class HelloController extends RequestHandler {

    public HelloController() {
        get((request, response) -> {
            System.out.printf("Hello %s %n", request);
        });

        get("/me", (request, response) -> {
            System.out.printf("Hello me %s %n", request);
        });

        get("/say/:name", (request, response) -> {
            System.out.printf("say/:name %s %n", request);
        });
    }
}
