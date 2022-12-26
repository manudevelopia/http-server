package info.developia.reactive.server;

public record Request(
        String method,
        String path,
        String query,
        String body) {
}
