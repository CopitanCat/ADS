package Lists;

import Interface.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    //List of data
    private Object[] data;
    //Size of list
    private int size;
    public MyArrayList(){
        data = new Object[10];
        size = 0;
    }
    public MyArrayList(int Size) throws IllegalAccessException {
        //Exception in size is negative
        if(Size<=0){
            throw new IllegalAccessException("Size need to be more than 0");
        }
        data = new Object[Size];
        size = 0;
    }

    //Grow the size of list
    private void grow() {
        int newCapacity = Math.max(data.length * 2, 10);
        //make new array and add it to array named by data
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //getting data by index
    @Override
    public T get(int index) {
        return (T) this.data[index];
    }

    //Add element to last place
    @Override
    public void add(Object element) {
        if (size == data.length) grow();
        this.data[this.size++] = element;
    }
    // Add element by index
    @Override
    public void add(Object element, int index) {
        if (size == data.length) grow();
        // Move right elements of data from index
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }
    //Return current size of list
    @Override
    public int size() {
        return this.size;
    }

    //removing data by index
    @Override
    public void remove(int index) {
        //Moving element of data to left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        //Determine element in size as null and reduce the size
        data[--size] = null;
    }

    //Change index element to the item
    @Override
    public void set(int index, Object item) {
       data[index] = item;
    }

    //Returns an iterator over the elements in this list in proper sequence
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) data[cursor++];
            }
        };
    }

}
