package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {

    private E key;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E key, BinaryTree<E> left, BinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;

    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder builder = new StringBuilder();
        builder.append(createPaddingAndAddKey(indent));

        if (this.getLeft() != null) {
            builder.append(System.lineSeparator());
            builder.append(getLeft().asIndentedPreOrder(indent + 2));
        }

        if (this.getRight() != null) {
            builder.append(System.lineSeparator());
            builder.append(getRight().asIndentedPreOrder(indent + 2));
        }
        return builder.toString();
    }

    private String createPaddingAndAddKey(int indent) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            builder.append(" ");
        }
        builder.append(getKey());

        return builder.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> tree = new ArrayList<>();

            tree.add(this);
            if (this.getLeft() != null) {
               tree.addAll( this.getLeft().preOrder());
            }
            if (this.getRight() != null){
                tree.addAll(this.getRight().preOrder());
            }


        return tree;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> tree = new ArrayList<>();

        if (this.getLeft() != null) {
            tree.addAll( this.getLeft().inOrder());
        }
        tree.add(this);
        if (this.getRight() != null){
            tree.addAll(this.getRight().inOrder());
        }


        return tree;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> tree = new ArrayList<>();

        if (this.getLeft() != null) {
            tree.addAll( this.getLeft().postOrder());
        }
        if (this.getRight() != null){
            tree.addAll(this.getRight().postOrder());
        }

        tree.add(this);

        return tree;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (this.getLeft() != null) {
            this.getLeft().forEachInOrder(consumer);
        }
        consumer.accept(this.getKey());
        if (this.getRight() != null) {
            this.getRight().forEachInOrder(consumer);
        }

    }
}
