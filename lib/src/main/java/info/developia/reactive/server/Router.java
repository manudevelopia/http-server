package info.developia.reactive.server;

import ratpack.core.handling.Chain;
import ratpack.func.Action;

public class Router {
    private Action<? super Chain> handlers;

    public void map(String basePath, RequestHandler handler) {
        Action<? super Chain> a = action -> action.get(basePath, new HandlerService(handler));
        handlers = Action.join(handlers, a);
    }

    public Action<? super Chain> handlers() {
        return handlers;
    }
}
