package info.developia.reactive.server;

public class Response {
    final ratpack.core.http.Response response;

    public Response(ratpack.core.http.Response response) {
        this.response = response;
    }
}
