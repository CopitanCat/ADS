public class MyMinHeap<T extends Comparable<T>>{
    private final MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }


    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i)  { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    private void siftUp(int i) {
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int n = heap.size();
        while (true) {
            int smallest = i;
            int left  = leftChild(i);
            int right = rightChild(i);

            if (left  < n && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < n && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest == i) break; // already in correct position
            swap(i, smallest);
            i = smallest;
        }
    }

    public void insert(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    public T getMin() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    public T extractMin() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Heap is empty");
        T min = heap.get(0);
        int last = heap.size() - 1;
        heap.set(0, heap.get(last)); // move last to root
        heap.remove(last);           // remove duplicate tail
        if (!isEmpty()) siftDown(0);
        return min;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
