package info.developia.util.structure.tree;

import info.developia.util.structure.Node;

public class NodeTree<T> extends Node<T> {
    NodeTree<T> left;
    NodeTree<T> right;

    public NodeTree(T value) {
        super(value);
    }
}
