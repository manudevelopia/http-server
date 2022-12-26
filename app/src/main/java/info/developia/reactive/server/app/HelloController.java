package info.developia.reactive.server.app;

import info.developia.reactive.server.RequestHandler;

public class HelloController extends RequestHandler {

    public HelloController() {
        get("/hello", (request, response) -> {
            System.out.printf("Hola %s %n", request);
        });
    }
}
