import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.function.Consumer;

import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int count;

    public BinarySearchTree() {

    }

    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
        this.count = 1;
    }


    public BinarySearchTree(Node<E> otherNode) {
        this.root = new Node<E>(otherNode.getValue());
        this.root.rightChild = new Node<E>(otherNode.getRight().getValue());
        this.root.leftChild = new Node<E>(otherNode.getLeft().getValue());
    }


    public static class Node<E> {
        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;


        public Node(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }
    }

    public void eachInOrder(Consumer<E> consumer) {

        nodeInOrder(this.root, consumer);

    }

    private void nodeInOrder(Node<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }
        nodeInOrder(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        nodeInOrder(node.getRight(), consumer);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void insert(E element) {

        if (this.root == null) {
            this.root = new Node<>(element);
            this.count++;
            return;
        }

        insertInto(element, root);


    }

    private void insertInto(E element, Node<E> node) {

        if (isGreater(element, node)) {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(element);
                count++;
                return;
            }
            insertInto(element, node.getRight());
        } else if (isLess(element, node)) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(element);
                count++;
                return;
            }
            insertInto(element, node.getLeft());
        } else if (isEqual(element, node)) {
            return;
        }


    }

//    private boolean hasNextLeftValue(Node<E> node) {
//        return node.leftChild != null;
//    }


    public boolean contains(E element) {
        Deque<Node<E>> deque = new ArrayDeque<>();

        deque.offer(this.root);
        while (!deque.isEmpty()) {
            Node<E> deletedNode = deque.poll();
            if (isEqual(element, deletedNode)) {
                return true;
            }
            if (deletedNode.leftChild != null) {
                deque.offer(deletedNode.leftChild);
            }

            if (deletedNode.rightChild != null) {
                deque.offer(deletedNode.rightChild);
            }
        }
        return false;
    }

    public BinarySearchTree<E> search(E element) {
        BinarySearchTree<E> treeToReturn = new BinarySearchTree<>();
        Deque<Node<E>> deque = new ArrayDeque<>();

        deque.offer(this.root);
        while (!deque.isEmpty()) {
            Node<E> deletedNode = deque.poll();
            if (isEqual(element, deletedNode)) {
                treeToReturn = new BinarySearchTree<>(deletedNode);
            }
            if (deletedNode.leftChild != null) {
                deque.offer(deletedNode.leftChild);
            }

            if (deletedNode.rightChild != null) {
                deque.offer(deletedNode.rightChild);
            }
        }
        return treeToReturn;

    }

    public void deleteMin() {
        ensureNotEmpty();
        goLeftAndDeleteNode(this.root);
        this.count--;

    }

    public void deleteMax() {
        ensureNotEmpty();
        goRightAndDeleteNode(this.root);
        count--;

    }

    public int count() {
        return this.count;
    }

    public E ceil(E element) {
        if (this.root == null) {
            return null;
        }
        return goRightAndFindNearestLargerValue(this.root, element);
    }

    public E floor(E element) {
        if (this.root == null) {
            return null;
        }
        return goLeftAndFindNearestSmallerValue(this.root, element);

    }

    private boolean isLess(E element, Node<E> node) {
        return element.compareTo(node.getValue()) < 0;
    }

    private boolean isGreater(E element, Node<E> node) {
        return element.compareTo(node.getValue()) > 0;
    }

    private boolean isEqual(E element, Node<E> node) {
        return element.compareTo(node.getValue()) == 0;
    }

    private void ensureNotEmpty() {
        if (this.root == null) {
            throw new IllegalArgumentException();
        }
    }

    private void goLeftAndDeleteNode(Node<E> root) {
        Node<E> current = this.root;
        Node<E> nextElement = current.getLeft();

        while (nextElement.getLeft() != null) {
            current = nextElement;
            nextElement = current.getLeft();

        }
        current.leftChild = nextElement.getRight();
        nextElement = null;


    }

    private void goRightAndDeleteNode(Node<E> root) {
        Node<E> current = this.root;
        Node<E> nextElement = current.getRight();

        while (nextElement.getRight() != null) {
            current = nextElement;
            nextElement = current.getRight();

        }
        current.rightChild = nextElement.getLeft();
        nextElement = null;

    }

    public int rank(E element) {
        List<E> validNodes = new ArrayList<>();
        Deque<Node<E>> elements = new ArrayDeque<>();
        elements.offer(this.root);
        while (!elements.isEmpty()) {
            Node<E> deletedNode = elements.poll();
            if (isGreater(element, deletedNode)) {
                validNodes.add(deletedNode.value);
            }
            if (deletedNode.leftChild != null) {
                elements.offer(deletedNode.leftChild);
            }

            if (deletedNode.rightChild != null) {
                elements.offer(deletedNode.rightChild);
            }
        }
        return validNodes.size();
    }

    public List<E> range(E first, E second) {
        List<E> elements = new ArrayList<>();
        Deque<Node<E>> deque = new ArrayDeque<>();

        deque.offer(this.root);
        while (!deque.isEmpty()) {
            Node<E> deletedNode = deque.poll();
            if (isLess(first, deletedNode) && isGreater(second, deletedNode) || isEqual(first, deletedNode) || isEqual(second, deletedNode)) {
                elements.add(deletedNode.value);
            }
            if (deletedNode.leftChild != null) {
                deque.offer(deletedNode.leftChild);
            }

            if (deletedNode.rightChild != null) {
                deque.offer(deletedNode.rightChild);
            }
        }

        return elements;
    }

    private E goLeftAndFindNearestSmallerValue(Node<E> root, E element) {

        Node<E> current = this.root;
        Node<E> nearestSmaller = null;
        while (current != null) {
            if (isGreater(element, current)) {
                nearestSmaller = current;
                current = current.getRight();
            } else if (isLess(element, current)) {
                current = current.getLeft();
            } else {
                Node<E> left = current.getLeft();
                if (left != null && nearestSmaller != null) {
                    nearestSmaller = isGreater(left.getValue(), nearestSmaller) ? left : nearestSmaller;
                } else if (nearestSmaller == null) {

                    nearestSmaller = left;
                }
                break;
            }


        }
        return nearestSmaller == null ? null : nearestSmaller.getValue();
    }

    private E goRightAndFindNearestLargerValue(Node<E> root, E element) {

        Node<E> current = this.root;
        Node<E> nearestBigger = null;
        while (current != null) {
            if (isLess(element, current)) {
                nearestBigger = current;
                current = current.getLeft();
            } else if (isGreater(element, current)) {
                current = current.getRight();
            } else {
                Node<E> right = current.getRight();
                if (right != null && nearestBigger != null) {
                    nearestBigger = isLess(right.getValue(), nearestBigger) ? right : nearestBigger;
                } else if (nearestBigger == null) {
                    nearestBigger = right;
                }
                break;
            }


        }
        return nearestBigger == null ? null : nearestBigger.getValue();
    }
}
