package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    Node<E> root;
    Node<E> left;
    Node<E> right;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> root) {
        this.copy(root);

    }

    private void copy(Node<E> root) {
        if (root == null) {
            return;
        }
        this.insert(root.value);
        this.copy(root.leftChild);
        this.copy(root.rightChild);
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.root == null) {
            root = new Node<>(element);
            return;
        } else {
            Node<E> parent = this.root;
            Node<E> previous = null;
            while (parent != null) {
                if (element.compareTo(parent.value) < 0) {
                    previous = parent;
                    parent = parent.leftChild;
                } else if (element.compareTo(parent.value) > 0) {
                    previous = parent;
                    parent = parent.rightChild;
                }
            }
            parent = previous;

            if (parent.value.compareTo(element) > 0) {
                parent.leftChild = new Node<>(element);
            } else if (parent.value.compareTo(element) < 0) {
                parent.rightChild = new Node<>(element);
            }
        }

    }

    @Override
    public boolean contains(E element) {
        Node<E> current = this.root;
        while (current != null) {
            if (current.value == element) {
                return true;
            }
            if (element.compareTo(current.value) < 0) {
                current = current.leftChild;
            } else if (element.compareTo(current.value) > 0) {
                current = current.rightChild;

            }
        }

        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        AbstractBinarySearchTree<E> treeToReturn = new BinarySearchTree<>();

        Node<E> parent = this.root;
        if (parent == null) {
            return treeToReturn;
        }
        while (parent != null) {
            if (parent.value == element ) {
                return new BinarySearchTree<>(parent);
            }

            if (parent.value.compareTo(element) > 0) {
                parent = parent.leftChild;
            } else {
                parent = parent.rightChild;
            }
        }


        return treeToReturn;
    }

    @Override
    public Node<E> getRoot() {

        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.left;
    }

    @Override
    public Node<E> getRight() {
        return this.right;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }
}
