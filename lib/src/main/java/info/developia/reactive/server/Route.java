package info.developia.reactive.server;

import java.util.function.BiConsumer;

public record Route(String method,
                    String pathPattern,
                    BiConsumer<Request, Response> handler) {
}
