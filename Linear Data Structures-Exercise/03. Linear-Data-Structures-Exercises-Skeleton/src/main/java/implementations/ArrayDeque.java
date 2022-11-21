package implementations;

import interfaces.Deque;

import java.io.ObjectStreamException;
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
            this.elements[head] = element;
        } else {
            this.elements[++head] = element;

        }
        size++;

    }


    @Override
    public void addFirst(E element) {
        this.  offer(element);

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
        this.elements[index + tail] = element;

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
        if (this.elements[this.head] != null) {
            E elementAt = getElementAt(this.head);
            this.elements[this.head] = null;
            this.head--;
            return elementAt;
        }
        return null;
    }

    @Override
    public E pop() {
        if (this.elements[tail] != null) {
            E elementAt = getElementAt(this.tail);
            this.elements[this.tail] = null;
            this.tail--;
            return elementAt;

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
        if(isEmpty()){
            return null;
        }
        for (int i = this.tail; i <= this.head; i++) {
            if (this.elements[i].equals(object)) {
                return getElementAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        checkForValidIndex(index);
        E elementToBeDeleted = this.getElementAt(index);
        removeByIndex(index);
        return elementToBeDeleted;
    }

    @Override
    public E remove(Object object) {
        if(isEmpty()){
            return null;
        }
        E elementToBeDeleted = null;
        for (int i = this.tail; i <=this.head; i++) {
            if (this.elements[i].equals(object)) {
                elementToBeDeleted = this.remove(i);
            }
        }
        return elementToBeDeleted;
    }

    @Override
    public E removeFirst() {
        if (this.size == 0) {
            return null;
        }
        return this.remove(this.head);
    }

    @Override
    public E removeLast() {
        if (this.size == 0){
            return null;
        }
            return this.remove(this.tail);
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
        Object [] newArray= new Object[this.size];
        for (int i = 0; i < newArray.length; i++) {

            newArray[i] = this.elements[this.tail+i];

        }
        this.elements = newArray;


    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            @Override
            public boolean hasNext() {
                return this.index !=tail;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private Object[] decreaseArray() {
        Object[] newArray = new Object[this.size*2];
        int begin = (newArray.length - this.size) / 2;

        for (int i = tail; i <= head; i++) {
            newArray[i + begin] = this.elements[i];
        }
        this.elements = newArray;
        head += begin;
        tail += begin;
        return this.elements;
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
        if (index < 0 || index > this.size+this.tail) {
            throw new IndexOutOfBoundsException("Invalid index, BrAtochka");
        }
    }

    private void insertAndShift(int index, E element) {
        int insertAtIndex = this.tail + index;
        if (this.capacity() - head <= this.tail) {
            for (int i = tail; i <= insertAtIndex; i++) {
                this.elements[i - 1] = this.elements[i];
            }
            this.elements[insertAtIndex] = element;
            this.tail--;
        } else {
            for (int i = head; i >= insertAtIndex; i--) {
                this.elements[i + 1] = this.elements[i];
            }
            this.elements[insertAtIndex] = element;
            this.head++;
        }

        this.size++;

    }


    private void removeByIndex(int index) {
        if(this.size==1 ){
            this.head=this.tail;
            this.elements[index] = null;

        }else {
            for (int i = index; i < this.head; i++) {
                this.elements[i] = this.elements[i+1];
            }
            this.elements[this.head] = null;
            this.head--;
        }

        this.size--;
    }
}
