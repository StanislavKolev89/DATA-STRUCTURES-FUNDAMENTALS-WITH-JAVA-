import junit.framework.TestCase;
import org.junit.Before;


import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest extends TestCase {
    private BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void beforeEach() {

        binarySearchTree = new BinarySearchTree<>();

    }

    public void testEachInOrder() {
    }

    public void testGetRoot() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        assertEquals(Integer.valueOf(7), binarySearchTree.getRoot().getValue());
    }

    @Test
    public void testInsert() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(33);
        binarySearchTree.insert(2);
        binarySearchTree.insert(25);
        binarySearchTree.insert(6);
        assertEquals(10, binarySearchTree.count());
    }

    public void testContains() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);

        assertTrue(binarySearchTree.contains(20));
        assertFalse(binarySearchTree.contains(222));

    }

    public void testSearch() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);


        BinarySearchTree<Integer> search = binarySearchTree.search(20);

        int count = search.count();

        assertEquals(Integer.valueOf(20), search.getRoot().getValue());
    }

    public void testRange() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        List<Integer> range = binarySearchTree.range(3, 10);

    }

    public void testDeleteMin() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(33);
        binarySearchTree.insert(2);
        binarySearchTree.insert(25);
        binarySearchTree.insert(6);
        binarySearchTree.deleteMin();
        List<Integer> range = binarySearchTree.range(1, 33);
        assertEquals(9, binarySearchTree.count());
    }

    public void testDeleteMax() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.deleteMax();
        List<Integer> range = binarySearchTree.range(5, 30);

    }

    public void testCount() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(33);
        binarySearchTree.insert(2);
        binarySearchTree.insert(25);
        binarySearchTree.insert(6);
        int rank = binarySearchTree.rank(34);
        assertEquals(10, rank);
        binarySearchTree.deleteMax();
        int rank1 = binarySearchTree.rank(34);
        assertEquals(9, rank1);

    }

    public void testRank() {
    }

    public void testCeil() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(33);
        binarySearchTree.insert(2);
        binarySearchTree.insert(25);
        binarySearchTree.insert(6);
        Integer ceil = binarySearchTree.ceil(15);
    }

    public void testFloor() {

        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        binarySearchTree.insert(33);
        binarySearchTree.insert(2);
        binarySearchTree.insert(25);
        binarySearchTree.insert(6);
        Integer floor = binarySearchTree.floor(20);
    }
}