package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);

    }

    private void heapifyUp(int i) {
        if(i>0){
            E elementToPromote = this.elements.get(i);
            while ( hasParent(i) && elementIsGreaterThanParent(elementToPromote, this.elements.get((i-1)/2))) {
                int parentIndex = (i - 1) / 2;
                Collections.swap(this.elements, parentIndex, i);
                i = parentIndex;
            }
        }
    }

    private boolean hasParent(int i) {
        return (i - 1 )/ 2 >=0;
    }

    private boolean elementIsGreaterThanParent(E elementToPromote, E parentOfElementToPromote) {
        return elementToPromote.compareTo(parentOfElementToPromote) > 0;
    }

    @Override
    public E peek() {
        if (this.size() == 0) {
            throw new IllegalStateException("Collection is empty");
        }

        return this.elements.get(0);
    }
}
