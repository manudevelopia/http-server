package info.developia.reactive.server;

public class ByeController extends RequestHandler {

    public ByeController() {
        get("/bye", (request, response) -> {
            System.out.printf("Adios %s %n", request);
        });
    }
}
