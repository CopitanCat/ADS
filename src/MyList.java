public interface MyList<T> extends Iterable<T>{
    //getting element by index
    T get(int index);

    // Append the element
    void add(T element);

    // Add element to specify index
    void add(T element , int index);

    // Return size of list
    int size();

    // removing element by index
    void remove(int index);

    // Replaces the element at the specified position with the given item.
    void set(int index, T item);
}
