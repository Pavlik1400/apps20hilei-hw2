package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList container;

    public Stack() {
        container = new ImmutableLinkedList();
    }

    public Stack(Object[] objects) {
        container = new ImmutableLinkedList(objects);
    }

    public int size() {
        return container.size();
    }

    public Object peek() {
        return container.getLast();
    }

    public void push(Object obj) {
        container = container.addLast(obj);
    }

    public Object pop() {
        Object last = container.getLast();
        container = container.removeLast();
        return last;
    }
}
