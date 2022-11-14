package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {

        arrayIsFull();

        this.elements[this.size++] = element;

        return true;
    }


    @Override
    public boolean add(int index, E element) {

        indexNotValid(index);

        addNewElement(index, element);

        return true;
    }


    @Override
    public E get(int index) {

        indexNotValid(index);

        return (E) this.elements[index];
    }


    @Override
    public E set(int index, E element) {
        indexNotValid(index);

        Object elementBeforeRecord = elements[index];

        elements[index] = element;

        return (E) elementBeforeRecord;
    }

    @Override
    public E remove(int index) {

        indexNotValid(index);
        Object elementToBeDeleted = this.elements[index];
        removeElement(index);

        return (E) elementToBeDeleted;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        return indexOfElement(element);
    }


    @Override
    public boolean contains(E element) {
        int i = indexOfElement(element);
        return i != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size ==0 ;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index<size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }


    private Object[] doubleArraySize() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= this.size;
    }

    private void indexNotValid(int index) {
        if (invalidIndex(index)) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size :%d", index, this.size));
        }
    }

    private void arrayIsFull() {
        if (this.size == this.elements.length) {
            this.elements = doubleArraySize();
        }
    }

    private void addNewElement(int index, E element) {
        arrayIsFull();
        Object temporaryElement = this.elements[index];
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = element;
        this.size++;
    }


    private int indexOfElement(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void removeElement(int index) {

        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
    }


}
