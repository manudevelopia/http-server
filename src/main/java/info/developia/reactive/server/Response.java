package info.developia.reactive.server;

public class Response {
    private int status = 200;
    private String body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response[" +
                "status=" + status +
                ", body='" + body + '\'' +
                ']';
    }
}
