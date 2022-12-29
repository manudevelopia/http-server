package info.developia.reactive.server.router;

import info.developia.reactive.server.Request;
import info.developia.reactive.server.Response;
import info.developia.util.structure.tree.NodeTree;

import java.util.function.BiConsumer;

class RouterNode extends NodeTree<String> {
    private final BiConsumer<Request, Response> handler;

    RouterNode(String value, BiConsumer<Request, Response> handler) {
        super(value);
        this.handler = handler;
    }


}
