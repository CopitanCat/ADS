package Lists;

import Interface.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

/**
 * A doubly-linked node that stores an element of type E together
 * with references to the previous and next nodes in the chain.
 */
    private static class MyNode<E>{
        E item ;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E item, MyNode<E> prev, MyNode<E> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    // return node in position of index
    private MyNode<T> nodeAt(int index) {
        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
    // First Node in list
    private MyNode<T> head;
    // Last Node in list
    private MyNode<T> tail;
    // Size of list
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0 ;
    }
    // Append the element by creating nodes
    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<T>(element, tail, null);
        if(tail == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        size ++;
    }

    // Add node in the node at index and move previous node at that index to the next node
    @Override
    public void add(T element, int index) {
        if (index == size){
            add(element);
        }
        if ( index == 0 ){
            MyNode<T> newNode = new MyNode<>(element, null, head);
            if (head != null){
                head.prev = newNode;
            }
            if (tail == null){
                tail = newNode;

            }
            size++;
            return;
        }
        MyNode<T> successor = nodeAt(index);
        MyNode<T> predecessor = successor.prev;
        MyNode<T> newNode = new MyNode<>(element, predecessor, successor);
        predecessor.next = newNode;
        successor.prev = newNode;
        size++;
    }


    //getting  element by index with nodeAt
    @Override
    public T get(int index) {
        return nodeAt(index).item;
    }

    // Removing node with unlinking node
    @Override
    public void remove(int index) {
        MyNode<T> node = nodeAt(index);
        T item = node.item;
        MyNode<T> prevNode = node.prev;
        MyNode<T> nextNode = node.next;

        if (prevNode == null) {
            head = nextNode; // removed head
        } else {
            prevNode.next = nextNode;
            node.prev = null; // help GC, prevent loops
        }

        if (nextNode == null) {
            tail = prevNode; // removed tail
        } else {
            nextNode.prev = prevNode;
            node.next = null; // help GC, prevent loops
        }

        node.item = null; // help GC
        size--;
    }


    // Change Element of index to new one
    @Override
    public void set(int index, T item) {
        nodeAt(index).item = item;
    }

    // Return current size of list
    @Override
    public int size() {
        return this.size;
    }

    //Returns an iterator over the elements in this list in proper sequence
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T elment = current.item;
                current = current.next;
                return elment;
            }
        };
    }
}
