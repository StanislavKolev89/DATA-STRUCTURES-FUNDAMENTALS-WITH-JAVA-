package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {

    private Object[] elements;

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;

    }

    @Override
    public void add(E element) {
        increaseCapacityIfNeeded();

        if (this.size == 0) {
            this.elements[head] = element;
        } else {
            this.elements[--tail] = element;

        }

        this.size++;
    }


    @Override
    public void offer(E element) {
        increaseCapacityIfNeeded();

        if (this.size == 0) {
            this.elements[tail] = element;
        } else {
            this.elements[++head] = element;

        }
        size++;

    }


    @Override
    public void addFirst(E element) {
        this.offer(element);

    }

    @Override
    public void addLast(E element) {
        this.add(element);

    }

    @Override
    public void push(E element) {
        this.add(element);
    }

    @Override
    public void insert(int index, E element) {
        if (index < 0 || index > this.head) {
            throw new IndexOutOfBoundsException();
        }

        insertAndShift(index, element);


    }


    @Override
    public void set(int index, E element) {
        checkForValidIndex(index);
        this.elements[index+tail] = element;

    }

    @Override
    public E peek() {
        if (invalidTailIndex()) {
            return null;
        }
        return getElementAt(this.tail);
    }

    @Override
    public E poll() {
        if (this.elements[this.head] == null) {
            return null;
        }
        E elementAt = getElementAt(this.head);
        this.elements[this.head] = null;
        this.head--;
        return elementAt;
    }

    @Override
    public E pop() {
        if (invalidTailIndex()) {
            return null;
        }
        return null;
    }

    @Override
    public E get(int index) {
        checkForValidIndex(index);
        return getElementAt(this.tail + index);
    }

    @Override
    public E get(Object object) {
        for (int i = this.tail; i <= this.head; i++) {
            if (this.elements[i].equals(object)) {
                return getElementAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E remove(Object object) {
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    private Object[] increaseArray() {
        Object[] newArray = new Object[this.capacity() * 2];
        int begin = (newArray.length - this.size) / 2;

        for (int i = tail; i <= head; i++) {
            newArray[i + begin] = this.elements[i];
        }
        this.elements = newArray;
        head += begin;
        tail += begin;
        return this.elements;
    }

    private boolean increaseCapacityIfNeeded() {
        if (this.head == this.capacity() - 1 || this.tail == 0) {
            this.elements = increaseArray();
            return true;
        }
        return false;
    }


    private E getElementAt(int index) {
        return (E) this.elements[index];
    }

    private boolean invalidTailIndex() {
        if (this.elements[this.tail] == null) {
            return true;
        }
        return false;
    }

    private void checkForValidIndex(int index) {
        if (index< 0 || index> this.size) {
            throw new IndexOutOfBoundsException("Invalid index, BrAtochka");
        }
    }

    private void insertAndShift(int index, E element) {
        int insertAtIndex = this.tail + index;
        if (this.capacity() - head <= this.tail) {
            for (int i = tail; i <=insertAtIndex; i++) {
                this.elements[i -1 ] = this.elements[i];
            }
            this.elements[insertAtIndex] = element;
            this.tail--;
        } else {
            for (int i = head; i >=insertAtIndex; i--) {
                this.elements[i+1] = this.elements[i];
            }
            this.elements[insertAtIndex] = element;
            this.head++;
        }

        this.size++;

    }


}
