public class MyStack<T> {
    private MyLinkedList<T> list;

    MyStack(){
        list = new MyLinkedList<>();
    }

    public void push(T element){
        list.add(element, 0);
    }

    public T pop(){
        T top = list.get(0);
        list.remove(0);
        return top;
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T peak(){
        return list.get(0);
    }
}
