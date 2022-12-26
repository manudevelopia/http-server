package info.developia.reactive.app;

import info.developia.reactive.server.Reactivo;

public class Main {
    public static void main(String[] args) {
        Reactivo.init()
                .addHandler("/hello", new HelloController())
                .addHandler("/bye", new ByeController())
                .virtualThreads(true)
                .threadPool(200)
                .start();
    }
}