import java.util.Iterator;

public class MyArrayList<T> implements MyList {
    private final Object[] data;
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

    @Override
    public T get(int index) {
        return (T) this.data[index];
    }

    @Override
    public void add(Object element) {
        this.data[this.size++] = element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
