package info.developia.reactive.server;

import java.util.Map;

public class Response {
    private int status;
    private Map<String, String> headers;
    private String contentType;
    private String body;

    public int status() {
        return status;
    }

    public void status(int status) {
        this.status = status;
    }

    public Map<String, String> headers() {
        return headers;
    }

    public void headers(Map<String, String> headers) {
        this.headers = headers;
    }

    public String contentType() {
        return contentType;
    }

    public void contentType(String contentType) {
        this.contentType = contentType;
    }

    public String body() {
        return body;
    }

    public void body(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response[" + "status=" + status + ", body='" + body + '\'' + ']';
    }

//    response.body();               // get response content
//    response.body("Hello");        // sets content to Hello
//    response.header("FOO", "bar"); // sets header FOO with value bar
//    response.raw();                // raw response handed in by Jetty
//    response.redirect("/example"); // browser redirect to /example
//    response.status();             // get the response status
//    response.status(401);          // set status code to 401
//    response.type();               // get the content type
//    response.type("text/xml");     // set content type to text/xml
}
