package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;
    private Node<E> tail;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E value) {
            this.element = value;
        }
    }

    public DoublyLinkedList() {
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        }
        Node<E> currentHead = this.head;
        this.head = newNode;
        this.head.previous = null;
        this.head.next = currentHead;
        currentHead.previous = this.head;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            Node<E> currentTail = this.tail;
            newNode.previous = currentTail;
            currentTail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node<E> newHead = this.head.next;
            this.head.next = null;
            this.head = newHead;
        }
        this.size--;
        return element;
    }

    private void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Illegal remove for empty LinkedList");
        }
    }

    @Override
    public E removeLast() {
        ensureNotEmpty();
        E element = this.tail.element;
        if (this.size == 1) {
            return removeFirst();
        }
        this.tail=this.tail.previous;
        this.tail.next=null;

        this.size--;

        return element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.head.element;
    }

    @Override
    public E getLast() {
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.element;
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
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
