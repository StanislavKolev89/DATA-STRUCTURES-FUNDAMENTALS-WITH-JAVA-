package implementations;

import junit.framework.TestCase;

public class ArrayDequeTest extends TestCase {

    private ArrayDeque<Integer> integers;

    public void setUp() throws Exception {
        this.integers = new ArrayDeque<>();

    }

    public void testAdd() {
//        this.integers.add(1);
//        this.integers.add(2);
//        this.integers.add(3);
//        this.integers.add(4);
//        this.integers.add(5);
//        this.integers.offer(1);
//        this.integers.offer(2);
//        this.integers.offer(3);
//        this.integers.offer(4);
//        this.integers.offer(5);

        this.integers.addLast(1);
        this.integers.addLast(2);
        this.integers.addLast(3);
        this.integers.addLast(4);
        this.integers.addLast(5);
        this.integers.addLast(6);
        this.integers.addFirst(1);
        this.integers.addFirst(2);
        this.integers.addFirst(3);
        this.integers.addFirst(4);
        this.integers.addFirst(5);
        this.integers.addFirst(6);

        System.out.println();
    }

    public void testOffer() {
    }

    public void testAddFirst() {
    }

    public void testAddLast() {
    }

    public void testPush() {
    }

    public void testInsert() {
    }

    public void testSet() {
    }

    public void testPeek() {
    }

    public void testPoll() {
    }

    public void testPop() {
    }

    public void testGet() {
    }

    public void testTestGet() {
    }

    public void testRemove() {
    }

    public void testTestRemove() {
    }

    public void testRemoveFirst() {
    }

    public void testRemoveLast() {
    }

    public void testSize() {
    }

    public void testCapacity() {
    }

    public void testTrimToSize() {
    }

    public void testIsEmpty() {
    }

    public void testIterator() {
    }
}