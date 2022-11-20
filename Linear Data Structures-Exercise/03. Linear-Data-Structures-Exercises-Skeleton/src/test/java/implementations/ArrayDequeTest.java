package implementations;

import junit.framework.TestCase;

public class ArrayDequeTest extends TestCase {

    private ArrayDeque<Integer> integers;

    public void setUp() throws Exception {
        this.integers = new ArrayDeque<>();

    }

    public void testAdd() {
        this.integers.add(1);
        this.integers.add(2);
        this.integers.add(3);
        this.integers.add(4);
        this.integers.add(5);
        this.integers.add(6);
        this.integers.add(7);
        this.integers.add(8);
        this.integers.add(9);
        this.integers.add(10);
        this.integers.add(11);
        this.integers.offer(12);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.offer(13);
        this.integers.push(12);
        this.integers.push(13);
        this.integers.push(14);
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