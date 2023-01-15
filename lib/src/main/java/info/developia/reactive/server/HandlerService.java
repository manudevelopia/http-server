package info.developia.reactive.server;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;

public class HandlerService implements Handler {

    private final RequestHandler handler;

    public HandlerService(RequestHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Context ctx) {
        handler.getHandler().accept(new Request(ctx.getRequest()), new Response(ctx.getResponse()));
        String name = ctx.getPathTokens().get("name");
        ctx.render("Hello " + name);
    }
}
