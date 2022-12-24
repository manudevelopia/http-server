package info.developia.reactive.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reactivo.init()
                .addRoute("/hello", new HelloController())
                .addRoute("/bye", new ByeController())
                .virtualThreads(true)
                .threadPool(200)
                .start();
    }
}
