package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

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
            if (current.value != null) {
                result.add(current.value);
            }

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
        this.addChildToParent(this, parentKey, child);


    }

    @Override
    public void removeNode(E nodeKey) {
        this.removeFirstNode(this, nodeKey);

    }

    @Override
    public void swap(E firstKey, E secondKey) {

//        List<Tree<E>> trees = new ArrayList<>();
//        this.addTreesToList(this, trees);
//        Tree<E> firstTree = trees.stream().filter(eTree -> eTree.value == firstKey).collect(Collectors.toList()).get(0);
//        Tree<E> secondTree = trees.stream().filter(eTree -> eTree.value == secondKey).collect(Collectors.toList()).get(0);
//        E temporaryValue = null;
//
//
//        if (firstKey == this.value) {
//            temporaryValue= firstTree.value;
//            this.value = secondKey;
//            secondTree.value = temporaryValue;
//        } else if (secondKey == this.value) {
//            temporaryValue = secondTree.value;
//                this.value = firstKey;
//                firstTree.value = temporaryValue;
//        }else{
//            temporaryValue = firstTree.value;
//            List<Tree<E>> temporaryChildren = firstTree.children;
//            firstTree.value = secondTree.value;
//            firstTree.children = secondTree.children;
//
//            secondTree.value = temporaryValue;
//            secondTree.children = temporaryChildren;
//
//        }


        List<Tree<E>> trees = new ArrayList<>();
        this.addTreesToList(this, trees);
        Tree<E> firstTree = trees.stream().filter(eTree -> eTree.value == firstKey).collect(Collectors.toList()).get(0);
        Tree<E> secondTree = trees.stream().filter(eTree -> eTree.value == secondKey).collect(Collectors.toList()).get(0);

        if(firstTree == null || secondTree == null){
            throw new IllegalArgumentException();
        }

        E temporaryValue = firstTree.value;
        List<Tree<E>> temporaryChildren = firstTree.children;
        Tree<E> parent = firstTree.parent;

        firstTree.value = secondTree.value;
        firstTree.parent = secondTree.parent;
        firstTree.children = secondTree.children;

        secondTree.value = temporaryValue;
        secondTree.children = temporaryChildren;
        secondTree.parent = parent;


    }


    private void addTreesToList(Tree<E> eTree, List<Tree<E>> trees) {
        for (Tree<E> child : eTree.children) {
            this.addTreesToList(child, trees);
        }
        trees.add(eTree);
    }

    private void depthFirstSearch(Tree<E> eTree, List<E> result) {
        for (Tree<E> child : eTree.children) {
            this.depthFirstSearch(child, result);
        }
        result.add(eTree.value);
    }

    private void removeFirstNode(Tree<E> eTree, E nodeKey) {
        if (eTree.value == nodeKey) {
            eTree.children.clear();
            eTree.value = null;
            return;
        }
        for (Tree<E> subTree : eTree.children) {

            removeFirstNode(subTree, nodeKey);
        }
    }

    private void addChildToParent(Tree<E> eTree, E value, Tree<E> child) {
        if (eTree.value == value) {
            child.parent=eTree;
            eTree.children.add(child);
            return;
        }
        for (Tree<E> subTree : eTree.children) {
            addChildToParent(subTree, value, child);

        }
    }


}



