package info.developia.reactive.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reactivo.init();
        Reactivo.addRoute("/hello", new HelloController());
        Reactivo.addRoute("/bye", new ByeController());
        Reactivo.start();
    }
}
