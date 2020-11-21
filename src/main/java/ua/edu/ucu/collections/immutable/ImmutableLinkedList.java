package ua.edu.ucu.collections.immutable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public final class ImmutableLinkedList implements ImmutableList{
    private final Node head;
    private final Node tail;

    public ImmutableLinkedList(Node head){
        Node newHead = new Node();
        Node current = newHead;

        Node next = head;
        while (next != null){
            // copy node
            current.previous().setNext(current);
            current.setValue(next.getValue());
            current.setPrevious(next.previous());
            // move to next in the chain
            next = next.next();
            current = new Node();
        }

    }

    @Override
    public ImmutableList add(Object e) {
        return null;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}

final class Node{
    @Setter
    private Node next = null;
    @Setter
    private Node previous = null;
    @Setter @Getter
    private Object value = null;

    public Node(){}
    public Node(Node previous, Node next, Object value){
        this.next = next;
        this.previous = previous;
        this.value = value;
    }
    public Node next(){
        return next;
    }
    public Node previous(){
        return previous;
    }
}