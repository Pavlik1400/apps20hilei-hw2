package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    // methods that are common with ImmutableArrayList are copy-paster,
    // only changed list type

    @Test
    public void testAdd() {
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableLinkedList();

        ImmutableList newList;
        newList = list.add(12);

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        assertEquals(newList.size(), 1);
        assertArrayEquals(newList.toArray(), new Object[]{12});

        // add to not empty
        list = new ImmutableLinkedList(notEmpty);
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
        ImmutableList list = new ImmutableLinkedList();
        list.add(1, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBadIndexNotEmptyTooBig(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{12, 13, 14, -12});
        list.add(12, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBadIndexNotEmptyTooSmall(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{12, 13, 14, -12});
        list.add(-12, 12);
    }

    @Test
    public void testAddIndex(){
        Object[] empty = new Object[]{};
        Object[] notEmpty = new Object[]{3, 2, 76, -12, 3};
        // add to empty
        ImmutableList list = new ImmutableLinkedList();

        // immutability
        list.add(0, 12);
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        list = list.add(0, 12);
        assertEquals(list.size(), 1);
        assertArrayEquals(list.toArray(), new Object[]{12});

        // many
        list = list.add(2);
        list = list.add(3);
        list = list.add(4);

        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{12, 2, 3, 4});

        list = new ImmutableLinkedList(notEmpty);
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
        ImmutableList list = new ImmutableLinkedList();

        list.addAll(new Object[]{1, 2, 3});

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        list = list.addAll(new Object[]{1, 2, 3});
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        // add to not empty
        list = new ImmutableLinkedList(notEmpty);
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
        ImmutableList list = new ImmutableLinkedList();

        list.addAll(0, new Object[]{1, 2, 3});

        // immutability
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), empty);

        list = list.addAll(0, new Object[]{1, 2, 3});
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        // add to not empty
        list = new ImmutableLinkedList(notEmpty);
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
        ImmutableList list = new ImmutableLinkedList();
        list.addAll(1, new Object[]{12, 12});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAllBadIndexNotEmptyTooBig(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.addAll(5, new Object[]{12, 12});
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAllBadIndexNotEmptyTooSmall(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.addAll(-1, new Object[]{12, 12});
    }

    @Test
    public void testGet(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        // 0
        assertEquals(list.get(0), 1);
        // size-1
        assertEquals(list.get(list.size()-1), 4);
        // inside
        assertEquals(list.get(2), 3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSmallIndex(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetBigIndex(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.get(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty(){
        ImmutableList list = new ImmutableLinkedList();
        list.get(0);
    }

    @Test
    public void testRemove(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
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
        list = new ImmutableLinkedList(new Object[]{3, 1, -12, 99});
        list = list.remove(2);
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{3, 1, 99});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSmallIndex(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemveBigIndex(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemveIndexEmpty(){
        ImmutableList list = new ImmutableLinkedList();
        list.remove(0);
    }

    @Test
    public void testSet(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
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
        ImmutableList list = new ImmutableLinkedList();
        list.set(0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexSmall(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.set(-1, 0);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexBig(){
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
        list.set(6, 0);
    }

    @Test
    public void testIndexOf(){
        // empty
        ImmutableList list = new ImmutableLinkedList();
        assertEquals(list.indexOf(0), -1);

        // not empty
        list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
        // present
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(-4), 3);

        // not present
        assertEquals(list.indexOf(12), -1);
        assertEquals(list.indexOf(-199), -1);


    }

    @Test
    public void testEmptySize() {
        ImmutableList list = new ImmutableLinkedList();
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
        ImmutableList list = new ImmutableLinkedList(new Object[]{3, 2, 76, -12, 3});
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
        ImmutableList list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
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
        ImmutableList list = new ImmutableLinkedList();
        assertArrayEquals(list.toArray(), new Object[]{});

        list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});
    }

    @Test
    public void testAddFirst() {
        // empty
        ImmutableLinkedList list = new ImmutableLinkedList();

        // immutability
        list.addFirst(12);
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), new Object[]{});


        list = list.addFirst(12);
        assertEquals(list.size(), 1);
        assertArrayEquals(list.toArray(), new Object[]{12});

        // not empty
        list = list.addFirst(13);
        assertEquals(list.size(), 2);
        assertArrayEquals(list.toArray(), new Object[]{13, 12});
    }

    @Test
    public void testAddLast() {
        // empty
        ImmutableLinkedList list = new ImmutableLinkedList();

        // immutability
        list.addLast(12);
        assertEquals(list.size(), 0);
        assertArrayEquals(list.toArray(), new Object[]{});


        list = list.addLast(12);
        assertEquals(list.size(), 1);
        assertArrayEquals(list.toArray(), new Object[]{12});

        // not empty
        list = list.addLast(13);
        assertEquals(list.size(), 2);
        assertArrayEquals(list.toArray(), new Object[]{12, 13});
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
        assertEquals(list.getFirst(), 1);
        list = list.addFirst(99);
        assertEquals(list.getFirst(), 99);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.getFirst();
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
        assertEquals(list.getLast(), -4);
        list = list.addLast(-5);
        assertEquals(list.getLast(), -5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.getLast();
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
        // immutability
        list.removeFirst();
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, -4});

        list = list.removeFirst();
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{2, 3, -4});

        list = list.removeFirst();
        assertEquals(list.size(), 2);
        assertArrayEquals(list.toArray(), new Object[]{3, -4});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3, -4});
        // immutability
        list.removeLast();
        assertEquals(list.size(), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, -4});

        list = list.removeLast();
        assertEquals(list.size(), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3});

        list = list.removeLast();
        assertEquals(list.size(), 2);
        assertArrayEquals(list.toArray(), new Object[]{1, 2});
    }

}
