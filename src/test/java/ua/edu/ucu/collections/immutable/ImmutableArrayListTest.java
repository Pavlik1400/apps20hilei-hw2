package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import ua.edu.ucu.collections.Node;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableArrayList();

        ImmutableList newList;
        newList = list.add(12);

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        assertEquals(newList.size(), 1);
        assertArrayEquals(newList.toArray(), new Object[]{12});

        // add to not empty
        list = new ImmutableArrayList(notEmpty);
        list = list.add(-12);
        assertEquals(list.size(), 6);
        assertArrayEquals(list.toArray(), new Object[]{3, 2, 76, -12, 3, -12});

        // add many
        list = list.add(7);
        list = list.add(8);
        list = list.add(9);
        assertEquals(list.size(), 9);
        assertArrayEquals(list.toArray(), new Object[]{3, 2, 76, -12, 3, -12, 7, 8, 9});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBadIndexEmpty(){
        ImmutableList list = new ImmutableArrayList();
        list.add(1, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBadIndexNotEmptyTooBig(){
        ImmutableList list = new ImmutableArrayList(new Object[]{12, 13, 14, -12});
        list.add(12, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBadIndexNotEmptyTooSmall(){
        ImmutableList list = new ImmutableArrayList(new Object[]{12, 13, 14, -12});
        list.add(-12, 12);
    }

    @Test
    public void testAddIndex(){
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableArrayList();

        // immutability
        list.add(0, 12);
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), new Object[]{});

        list = list.add(0, 12);
        assertEquals(list.size(), 1);
        assertArrayEquals(list.toArray(), new Object[]{12});

        // many
        list = list.add(2);
        list = list.add(3);
        list = list.add(4);

        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{12, 2, 3, 4});

        list = new ImmutableArrayList(notEmpty);
        // 0
        list = list.add(0, 99);
        // size
        list = list.add(list.size(), -99);
        // inside
        list = list.add(2, 100);
        assertEquals(list.size(), 8);
        assertArrayEquals(list.toArray(), new Object[]{99, 3, 100, 2, 76, -12, 3, -99});
    }

    @Test
    public void testAddAll(){
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableArrayList();

        list.addAll(new Object[]{1, 2, 3});

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        list = list.addAll(new Object[]{1, 2, 3});
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        // add to not empty
        list = new ImmutableArrayList(notEmpty);
        list = list.addAll(new Object[]{5, 4, 3, 2, 1});
        assertEquals(list.size(), 10);
        assertArrayEquals(list.toArray(), new Object[]{3, 2, 76, -12, 3, 5, 4, 3, 2, 1});

        // add many
        list = list.addAll(new Object[]{0});
        list = list.addAll(new Object[]{-12, -13, -14});
        assertEquals(list.size(), 14);
        assertArrayEquals(list.toArray(), new Object[]{3, 2, 76, -12, 3, 5, 4, 3, 2, 1, 0, -12, -13, -14});
    }

    @Test
    public void addAllIndex(){
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableArrayList();

        list.addAll(0, new Object[]{1, 2, 3});

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        list = list.addAll(0, new Object[]{1, 2, 3});
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        // add to not empty
        list = new ImmutableArrayList(notEmpty);
        // 0
        list = list.addAll(0, new Object[]{5, 4});
        assertEquals(list.size(), 7);
        assertArrayEquals(list.toArray(), new Object[]{5, 4, 3, 2, 76, -12, 3});

        // size
        list = list.addAll(list.size(), new Object[]{-5, -4});
        assertEquals(list.size(), 9);
        assertArrayEquals(list.toArray(), new Object[]{5, 4, 3, 2, 76, -12, 3, -5, -4});

        // inside
        list = list.addAll(2, new Object[]{99, -99});
        assertEquals(list.size(), 11);
        assertArrayEquals(list.toArray(), new Object[]{5, 4, 99, -99, 3, 2, 76, -12, 3, -5, -4});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAllBadIndexEmpty(){
        ImmutableList list = new ImmutableArrayList();
        list.addAll(1, new Object[]{12, 12});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAllBadIndexNotEmptyTooBig(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.addAll(5, new Object[]{12, 12});
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAllBadIndexNotEmptyTooSmall(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.addAll(-1, new Object[]{12, 12});
    }

    @Test
    public void testGet(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        // 0
        assertEquals(list.get(0), 1);
        // size-1
        assertEquals(list.get(list.size()-1), 4);
        // inside
        assertEquals(list.get(2), 3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSmallIndex(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetBigIndex(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.get(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty(){
        ImmutableList list = new ImmutableArrayList();
        list.get(0);
    }

    @Test
    public void testRemove(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        // immutability
        list.remove(0);
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(),new Object[]{1, 2, 3, 4});
        // last
        list = list.remove(list.size()-1);
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        // first
        list = list.remove(0);
        assertEquals(list.size(), 2);
        assertArrayEquals(list.toArray(), new Object[]{2, 3});

        // inside
        list = new ImmutableArrayList(new Object[]{3, 1, -12, 99});
        list = list.remove(2);
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{3, 1, 99});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSmallIndex(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemveBigIndex(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemveIndexEmpty(){
        ImmutableList list = new ImmutableArrayList();
        list.remove(0);
    }

    @Test
    public void testSet(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        // immutability
        list.set(1, 99);
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});

        // 0
        list = list.set(0, 99);
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{99, 2, 3, 4});

        // last
        list = list.set(3, -99);
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{99, 2, 3, -99});

        // inside
        list = list.set(1, 23);
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{99, 23, 3, -99});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmpty(){
        ImmutableList list = new ImmutableArrayList();
        list.set(0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexSmall(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.set(-1, 0);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexBig(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        list.set(6, 0);
    }

    @Test
    public void testIndexOf(){
        // empty
        ImmutableList list = new ImmutableArrayList();
        assertEquals(list.indexOf(0), -1);

        // not empty
        list = new ImmutableArrayList(new Object[]{1, 2, 3, -4});
        // present
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(-4), 3);

        // not present
        assertEquals(list.indexOf(12), -1);
        assertEquals(list.indexOf(-199), -1);


    }

    @Test
    public void testEmptySize() {
        ImmutableList list = new ImmutableArrayList();
        assertEquals(list.size(), 0);

        // immutability
        list.add(12);
        assertEquals(list.size(), 0);

        list = list.add(12);
        assertEquals(list.size(), 1);

        list = list.remove(0);
        assertEquals(list.size(), 0);
    }

    @Test
    public void testSize() {
        ImmutableList list = new ImmutableArrayList(new Object[]{3, 2, 76, -12, 3});
        assertEquals(list.size(), 5);

        // immutability
        list.add(12);
        assertEquals(list.size(), 5);
        list = list.add(12);
        assertEquals(list.size(), 6);

        list = list.remove(0);
        assertEquals(list.size(), 5);
    }

    @Test
    public void testClearAndIsEmpty(){
        ImmutableList list = new ImmutableArrayList(new Object[]{1, 2, 3, -4});
        assertFalse(list.isEmpty());
        // immutability
        list.clear();
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, -4});
        assertFalse(list.isEmpty());

        list = list.clear();
        assertEquals(list.size(),0);
        assertArrayEquals(list.toArray(), new Object[]{});
        assertTrue(list.isEmpty());

        // clear empty
        list = list.clear();
        assertEquals(list.size(),0);
        assertArrayEquals(list.toArray(), new Object[]{});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray(){
        // actually was tested in all methods above
        // empty
        ImmutableList list = new ImmutableArrayList();
        assertArrayEquals(list.toArray(), new Object[]{});

        list = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});
    }

    @Test
    public void testToString() {
        // empty
        ImmutableList list = new ImmutableArrayList();
        assertEquals(list.toString(), "[]");

        list = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(list.toString(), "[1, 2, 3]");

    }

    // those are just for 100% coverage
    @Test
    public void testNode() {
        // empty
        Node node = new Node(13);
        assertEquals(node.getValue(), 13);
        assertNull(node.next());

        Node anotherNode = new Node(12, node);
        assertEquals(anotherNode.getValue(), 12);
        assertEquals(anotherNode.next(), node);

        anotherNode.setNext(null);
        assertNull(anotherNode.next());

        anotherNode.setValue(14);
        assertEquals(anotherNode.getValue(), 14);
    }

    @Test(expected = NegativeArraySizeException.class)
    // not null length was tested in previous tests
    public void testArrToLinkedListNullLength() {
        Object[] arr = new Object[]{};
        ImmutableLinkedList.arrToLinkedList(arr);
    }
    
}
