package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        Node(E element) {
            this.element = element;
        }


    }

    private Node<E> top;
    private int size;


    public Stack() {
        this.top = null;
        this.size = 0;
    }


    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        this.size++;
    }

    @Override
    public E pop() {
        checkForEmptyStack();
        Node<E> newTop = top.next;
        Node<E> nodeToDelete = top;
        top = newTop;
        this.size--;


        return (E) nodeToDelete.element;
    }

    private void checkForEmptyStack() {
        if (this.size == 0) {
            throw new IllegalStateException("Empty stack");
        }
    }

    @Override
    public E peek() {
        checkForEmptyStack();

        return top.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = (E) this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}
