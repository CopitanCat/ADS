import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private Object[] data;
    private int size;
    public MyArrayList(){
        data = new Object[10];
        size = 0;
    }
    public MyArrayList(int Size) throws IllegalAccessException {
        if(Size<=0){
            throw new IllegalAccessException("Size need to be more than 0");
        }
        data = new Object[Size];
        size = 0;
    }

    private void grow() {
        int newCapacity = Math.max(data.length * 2, 10);
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public T get(int index) {
        return (T) this.data[index];
    }

    @Override
    public void add(Object element) {
        if (size == data.length) grow();
        this.data[this.size++] = element;
    }

    @Override
    public void add(Object element, int index) {
        if (size == data.length) grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    @Override
    public void set(int index, Object item) {
       data[index] = item;
    }

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
