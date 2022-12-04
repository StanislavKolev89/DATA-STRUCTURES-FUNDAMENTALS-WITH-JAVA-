package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    private List<E> elements;

    public PriorityQueue() {
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

    @Override
    public E peek() {
        ensureNonEmpty();

        return this.elements.get(0);
    }

    private void ensureNonEmpty() {
        if(this.size()==0){
            throw new IllegalStateException("Heap is empty");
        }

    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.elements.get(0);
        Collections.swap(this.elements, 0,this.elements.size()-1);
        this.elements.remove(this.elements.size()-1);
        this.heapifyDown(0);
        return element;
    }

    private void heapifyDown(int i) {
        while(i<this.size()/2){

            int leftChildIndex= 2*i+1;
            int rightChildIndex= 2*i+2;
            E elementToSwap = getLeftChild(i);
            int newIndex = leftChildIndex;

                if( rightChildIndex< this.size() && elementIsGreaterThanParent(this.getRightChild(i),this.getLeftChild(i))){
                    elementToSwap= getRightChild(i);
                    newIndex = rightChildIndex;
                }

                if(elementIsGreaterThanParent(this.elements.get(i),elementToSwap)){
                    break;
                }

                Collections.swap(this.elements,newIndex,i);
                i = newIndex;

        }


    }

    private E getLeftChild(int index){
        return this.elements.get(index*2+1);
    }

    private E getRightChild(int index){
        return  this.elements.get(index*2+2);
    }

    private boolean elementIsGreaterThanParent(E parent, E child) {
        return parent.compareTo(child) > 0;
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
}
