package implementations;

import junit.framework.TestCase;
import org.junit.Test;

public class ReversedListTest extends TestCase {

    @Test
    public void testAdd() {
        ReversedList<Integer> integers = new ReversedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        assertEquals(9, integers.size());
    }

    @Test
    public void testSize() {
    }

    @Test
    public void testCapacity() {

    }

    @Test
    public void testGet() {
        ReversedList<Integer> integers = new ReversedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        Integer integer = integers.get(2);
        assertEquals(4, integers.size());

    }

    @Test
    public void testRemoveAt() {
        ReversedList<Integer> integers = new ReversedList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.removeAt(0);
        integers.removeAt(0);
        integers.removeAt(0);

        assertEquals(Integer.valueOf(4), integers.get(0));
    }


    @Test
    public void removeAtShouldRemoveCorrectElement() {
        ReversedList<Integer> list = new ReversedList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.removeAt(0);
       assertEquals(2, (int)list.get(0));
   }

    public void testIterator() {
    }
}