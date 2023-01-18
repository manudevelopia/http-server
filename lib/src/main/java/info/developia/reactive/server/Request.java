package info.developia.reactive.server;

public record Request(
        String method,
        String path,
        String query,
        String contentType,
        String body) {
}

//        request.attributes();             // the attributes list
//        request.attribute("foo");         // value of foo attribute
//        request.attribute("A", "V");      // sets value of attribute A to V
//        request.body();                   // request body sent by the client
//        request.bodyAsBytes();            // request body as bytes
//        request.contentLength();          // length of request body
//        request.contentType();            // content type of request.body
//        request.contextPath();            // the context path, e.g. "/hello"
//        request.cookies();                // request cookies sent by the client
//        request.headers();                // the HTTP header list
//        request.headers("BAR");           // value of BAR header
//        request.host();                   // the host, e.g. "example.com"
//        request.ip();                     // client IP address
//        request.params("foo");            // value of foo path parameter
//        request.params();                 // map with all parameters
//        request.pathInfo();               // the path info
//        request.port();                   // the server port
//        request.protocol();               // the protocol, e.g. HTTP/1.1
//        request.queryMap();               // the query map
//        request.queryMap("foo");          // query map for a certain parameter
//        request.queryParams();            // the query param list
//        request.queryParams("FOO");       // value of FOO query param
//        request.queryParamsValues("FOO")  // all values of FOO query param
//        request.raw();                    // raw request handed in by Jetty
//        request.requestMethod();          // The HTTP method (GET, ..etc)
//        request.scheme();                 // "http"
//        request.servletPath();            // the servlet path, e.g. /result.jsp
//        request.session();                // session management
//        request.splat();                  // splat (*) parameters
//        request.uri();                    // the uri, e.g. "http://example.com/foo"
//        request.url();                    // the url. e.g. "http://example.com/foo"
//        request.userAgent();              // user agent
