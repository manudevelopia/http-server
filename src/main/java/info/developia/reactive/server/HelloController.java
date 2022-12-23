package info.developia.reactive.server;

public class HelloController extends RequestHandler {

    public HelloController() {
        get("/hello", (request, response) -> {
            System.out.printf("Hola %s %n", request);
        });
    }
}
