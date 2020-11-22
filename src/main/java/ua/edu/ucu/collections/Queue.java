package ua.edu.ucu.collections;

import lombok.Getter;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList container;

    public Queue(){
        container = new ImmutableLinkedList();
    }

    public Queue(Object[] objects){
        container = new ImmutableLinkedList(objects);
    }

    public int size(){
        return container.size();
    }

    public Object peek(){
        return container.getFirst();
    }

    public Object last(){
        return container.getLast();
    }

    public void enqueue(Object obj){
        container = container.addLast(obj);
    }

    public Object dequeue(Object obj){
        Object first = container.getFirst();
        container = container.removeFirst();
        return first;
    }
}
