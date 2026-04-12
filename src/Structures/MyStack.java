package Structures;

import Lists.MyLinkedList;

public class MyStack<T> {
    private MyLinkedList<T> list;

    MyStack(){
        list = new MyLinkedList<>();
    }


    // add element to top
    public void push(T element){
        list.add(element, 0);
    }

    // remove and return top element
    public T pop(){
        T top = list.get(0);
        list.remove(0);
        return top;
    }

    // Returns true if the stack contains no elements.
    public boolean empty(){
        return list.size() == 0;
    }

    // Return size of list
    public int size(){
        return list.size();
    }


    // return top element without removing
    public T peak(){
        return list.get(0);
    }
}
