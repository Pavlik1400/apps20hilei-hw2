package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImmutableList list = new ImmutableArrayList();
        System.out.printf("size: %d%n", list.size());

        list = list.addAll(new Object[]{1, 2, 3, 4});

        System.out.printf("0th element: %d; third element: %d%n", (int) list.get(0),(int) list.get(3));
        list = list.add(12);
        System.out.printf("size: %d, index of 12: %d%n", list.size(), list.indexOf((Object) 12));

        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        list = list.remove(3);
        arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        list = list.addAll(2, new Object[]{9, 8, -12});
        arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.printf("isEmpty: %b%n", list.isEmpty());
        list = list.clear();
        System.out.printf("isEmpty: %b%n", list.isEmpty());

    }
}
