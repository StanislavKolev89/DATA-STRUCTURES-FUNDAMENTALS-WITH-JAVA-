package implementations;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReversedList<E> implements interfaces.ReversedList<E> {
    private Object[] elements;

    private final int DEFAULT_CAPACITY = 2;
    private int head;
    private int tail;
    private int size;

    public ReversedList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.tail = this.elements.length - 1;
        this.size = 0;

    }

    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.elements[head] = element;
        } else {
            if (this.size == this.capacity()) {
                this.elements = grow();
                this.tail += this.size;
                this.head = this.elements.length - 1;

            }
            this.elements[--tail] = element;

        }
        this.size++;

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
    public E get(int index) {
        if (this.size == 0 || index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Invalid index! " + index);
        }

        return (E) this.elements[this.tail + index];
    }

    @Override
    public void removeAt(int index) {
        int realIndex = this.elements.length-1 + index;
        for (int i = realIndex; i >= this.tail; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[tail] = null;
        this.tail++;
        this.size--;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = tail;

            @Override
            public boolean hasNext() {
                return get(index++) != null;
            }

            @Override
            public Object next() {
                return get(index++);
            }
        };
    }


    private Object[] grow() {

        Object[] newArray = new Object[this.capacity() * 2];

        for (int i = newArray.length - 1; i >= this.size; i--) {
            newArray[i] = this.elements[i - this.size];
        }
        this.elements = newArray;

        return this.elements;
    }
}
