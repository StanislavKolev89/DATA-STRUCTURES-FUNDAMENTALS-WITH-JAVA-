package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);
        nextElement.next = this.head;
        this.head = nextElement;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> lastAddedElement = new Node<>(element);


        if (this.size == 0) {
            this.head = lastAddedElement;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = lastAddedElement;
        }

        this.size++;

    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();
        Node<E> toRemove = this.head;
        this.head = toRemove.next;
        this.size--;

        return toRemove.element;
    }


    @Override
    public E removeLast() {
        ensureNotEmpty();
        Node<E> previous = this.head;
        Node<E> toRemove = this.head.next;
        if (this.size == 1) {
            return previous.element;
        } else {
            while (toRemove.next != null) {
                previous = toRemove;
                toRemove = toRemove.next;

            }
            previous.next = null;
        }
        this.size--;
        return toRemove.element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.head.element;
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        Node<E> nodeToReturn = this.head;
        if (this.size == 1) {
            return this.head.element;
        } else {
            while (nodeToReturn.next != null) {
                nodeToReturn = nodeToReturn.next;
            }

        }
        return nodeToReturn.element;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.element;

                current = current.next;
                return value;
            }
        };
    }

    private void ensureNotEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
