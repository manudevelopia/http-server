package info.developia.reactive.app;

import info.developia.reactive.server.RequestHandler;

import java.util.logging.Logger;

public class HelloController extends RequestHandler {
    private static final Logger log = Logger.getLogger(HelloController.class.getName());

    public HelloController() {
        get((request, response) -> {
            log.info("Hello");
        });

        get("/hello", (request, response) -> {
            log.info("Hello hello");
        });

        get("/me", (request, response) -> {
            log.info("Hello me %s %n");
        });

        get("/say/:name", (request, response) -> {
            log.info("say/:name %s %n");
        });
    }
}
