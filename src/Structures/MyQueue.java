package Structures;

import Lists.MyLinkedList;

public class MyQueue<T> {
    private final MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the back of the queue.
    public void enqueue(T item) {
        list.add(item);
    }

    //Removes and returns the element at the front of the queue.
    public T dequeue() {
        T front = list.get(0);
        list.remove(0);
        return front;
    }

    //Returns the element at the front of the queue without removing it.
    public T peek() {
        return list.get(0);
    }

    //Returns true if the queue contains no elements.
    public boolean isEmpty() {
        return list.size() == 0;
    }

    //Returns the number of elements in the queue.
    public int size() {
        return list.size();
    }
}
