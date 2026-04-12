public class MyQueue<T> {
    private final MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }
    public T dequeue() {
        T front = list.get(0);
        list.remove(0);
        return front;
    }

    public T peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
