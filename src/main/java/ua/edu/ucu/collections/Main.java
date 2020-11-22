package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ImmutableList list = new ImmutableLinkedList();
        System.out.printf("size: %d%n", list.size());
        Object[] arr;

        list = list.addAll(new Object[]{1, 2, 3, 4});
        System.out.printf("size: %d%n", list.size());
        arr = list.toArray();
        System.out.println(Arrays.toString(arr));


        System.out.printf("0th element: %d; third element: %d%n", (int) list.get(0), (int) list.get(3));
        list = list.add(12);
        System.out.printf("size: %d, index of 12: %d%n", list.size(), list.indexOf((Object) 12));

        arr = list.toArray();
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
//        Node head = new Node(1);
//        head.setNext(new Node(4));
//        Node node = head.next();
//        node.setNext(new Node(6));
//        print_linked_list(head);
//
//        Node newHead = new Node();
//        Node newTail = new Node();
//        int size = ImmutableLinkedList.copyLinkedList(head, newHead, newTail);
//        print_linked_list(newHead);
//
//        head = new Node(12);
//        ImmutableLinkedList.copyLinkedList(head, newHead, newTail);
//        print_linked_list(newHead);
//
//        head.setNext(new Node(13));
//        ImmutableLinkedList.copyLinkedList(head, newHead, newTail);
//        print_linked_list(newHead);


    }
    private static void print_linked_list(Node head){
        if (head == null){
            System.out.println("[]");
        }
        Node current = head;
        System.out.printf("[");
        while (current != null){
            System.out.printf("%d, ", (int) current.getValue());
            current = current.next();
        }
        System.out.printf("]%n");
    }
}
