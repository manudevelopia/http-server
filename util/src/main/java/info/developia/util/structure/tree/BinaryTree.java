package info.developia.util.structure.tree;

import java.util.function.BiFunction;

public class BinaryTree<T> {
    private NodeTree<T> root;
    private final BiFunction<T, T, Integer> comparator;
    private int size = 0;

    public BinaryTree(BiFunction<T, T, Integer> comparator) {
        this.comparator = comparator;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private NodeTree<T> addRecursive(NodeTree<T> current, T value) {
        if (current == null) {
            ++size;
            return new NodeTree<>(value);
        }
        if (comparator.apply(value, current.value) > 0) {
            current.left = addRecursive(current.left, value);
        } else if (comparator.apply(value, current.value) < 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public boolean contains(T value) {
        return find(value) != null;
    }

    public T find(T value) {
        return findRecursive(root, value);
    }

    private T findRecursive(NodeTree<T> current, T value) {
        if (current == null) {
            return null;
        }
        if (comparator.apply(value, current.value) > 0) {
            return findRecursive(current.left, value);
        } else if (comparator.apply(value, current.value) < 0) {
            return findRecursive(current.right, value);
        }
        return current.value;
    }

    public int size() {
        return size;
    }
}
