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
    assertEquals(3,this.integers.size());
    }

    public void testOffer() {
        this.integers.offer(1);
        this.integers.offer(2);
        this.integers.offer(3);
        assertEquals(3,this.integers.size());
    }

    public void testAddFirst() {
      this.integers.offer(12);
      this.integers.offer(12);

        assertEquals(2,this.integers.size());
    }

    public void testAddLast() {
        this.integers.addLast(12);
        this.integers.add(13);
        this.integers.push(14);
        assertEquals(Integer.valueOf(13),this.integers.get(1));
        assertEquals(3,integers.size());
    }

    public void testPush() {
        this.integers.push(1);
        this.integers.push(2);
        System.out.println(this.integers.removeLast());
        assertEquals(1,this.integers.size());
        System.out.println(this.integers.removeLast());
    }

    public void testInsert() {
    }

    public void testSet() {
        this.integers.add(1);
        this.integers.add(2);
        System.out.println(this.integers.get(0));
        System.out.println(this.integers.get(1));

        this.integers.set(0,666);
        assertEquals(2,this.integers.size());
        System.out.println(this.integers.get(0));
        System.out.println(this.integers.get(1));
    }

    public void testPeek() {
        this.integers.offer(1);
        this.integers.offer(2);
        this.integers.offer(3);
        assertEquals(Integer.valueOf(1),this.integers.peek());
    }

    public void testPoll() {
        assertNull(this.integers.poll());
        this.integers.offer(1);
        this.integers.offer(2);
        this.integers.offer(3);
        assertEquals(Integer.valueOf(3),this.integers.poll());
    }

    public void testPop() {
        assertNull(this.integers.pop());
        this.integers.offer(1);
        this.integers.offer(2);
        this.integers.offer(3);
        assertEquals(Integer.valueOf(1),this.integers.pop());

    }

    public void testGet() {
        assertNull(this.integers.get(1));
    }

    public void testTestGet() {

        this.integers.add(123);

        System.out.println(this.integers.get(Integer.valueOf(1232)));

    }

    public void testRemove() {
        this.integers.add(12);
        this.integers.remove(0);
        assertEquals(0,this.integers.size());
        this.integers.add(12);
        this.integers.add(13);
        this.integers.offer(1);
        this.integers.offer(2);
        Integer one = this.integers.removeFirst();
        Integer two = this.integers.removeFirst();

        assertEquals(2,this.integers.size());
    }

    public void testTestRemove() {

    }

    public void testRemoveFirst() {
        this.integers.add(12);
        this.integers.add(13);
        this.integers.add(14);
        this.integers.add(15);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        this.integers.add(16);
        assertEquals(Integer.valueOf(12),this.integers.removeFirst());
        assertEquals(25,this.integers.size());
    }

    public void testRemoveLast() {
        this.integers.add(12);
        this.integers.add(13);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(14);
        this.integers.add(5551);
        assertEquals(Integer.valueOf(5551),this.integers.removeLast());
        assertEquals(19,this.integers.size());
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