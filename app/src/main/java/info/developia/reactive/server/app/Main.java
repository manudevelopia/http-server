package info.developia.reactive.server.app;

import info.developia.reactive.server.Reactivo;

public class Main {
    public static void main(String[] args) {
        Reactivo.init()
                .addRoute("/hello", new HelloController())
                .addRoute("/bye", new ByeController())
                .virtualThreads(true)
                .threadPool(200)
                .start();
    }
}