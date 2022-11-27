package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        this.children.addAll(Arrays.asList(subtrees));
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();

        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();
            result.add(current.value);

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.depthFirstSearch(this, result);
        return result;
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        this.addChildToParent(this,parentKey, child);


    }

    @Override
    public void removeNode(E nodeKey) {
        this.removeFirstNode(this,nodeKey);

    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }

    private void depthFirstSearch(Tree<E> eTree, List<E> result) {
        for (Tree<E> child : eTree.children) {
            this.depthFirstSearch(child, result);
        }
        result.add(eTree.value);
    }

    private void removeFirstNode(Tree<E> eTree, E nodeKey) {
    }

    private void addChildToParent(Tree<E> eTree,E value, Tree<E> child) {
        if (eTree.value == value) {
            eTree.children.add(child);
            return;
        }
        for (Tree<E> subTree: eTree.children) {
            addChildToParent(subTree,value,child);

        }

    }
}



