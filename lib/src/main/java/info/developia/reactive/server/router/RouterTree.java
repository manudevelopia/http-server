package info.developia.reactive.server.router;

import info.developia.util.structure.tree.BinaryTree;

import java.util.function.BiFunction;

public class RouterTree extends BinaryTree<RouterNode> {
    public RouterTree(BiFunction comparator) {
        super(comparator);
    }
}
