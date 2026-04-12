public interface MyList<T> extends Iterable<T>{
    T get(int index);
    void add(T element);
    void add(T element , int index);
    int size();
}
