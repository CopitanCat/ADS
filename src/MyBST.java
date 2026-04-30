import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> implements Iterable<Map.Entry<K, V>>{


    private static class BSTNode<K, V>{
        K key;
        V value;

        BSTNode<K, V> left;
        BSTNode<K, V> right;

        BSTNode<K, V> parent;

        public BSTNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private BSTNode<K, V> root;
    private int size;

    public void put(K key, V value){
        BSTNode<K, V> node = root;
        while (root != null){
            if (key.compareTo(node.key)<0){
                if (node.left == null){
                    size++;
                    node.left = new BSTNode<>(key, value);
                    node.left.parent = node;
                    return;
                }
                node = node.left;
            }
            else if (key.compareTo(node.key)>0){
                if (node.right == null){
                    size++;
                    node.right = new BSTNode<>(key,value);
                    node.right.parent = node;
                    return;
                }
                node =node.right;
            }
            else {
                node.value = value;
                size++;
                return;
            }
        }
        root = new BSTNode<>(key,value);
    }

    public int size(){
        return size;
    }

    public V get(K key){
        BSTNode<K, V> current = root;

        while (current != null){
            if (key.compareTo(current.key)<0) current = current.left;
            else if (key.compareTo(current.key)>0) current = current.right;
            else return current.value;
        }
        return null;
    }

    public void delete(K key){
        BSTNode<K, V> current = root;
        while (current != null){
            if (key.compareTo(current.key)<0) current = current.left;
            else if (key.compareTo(current.key)>0) current = current.right;
            else break;
        }
        if (current == null) return;
        size--;

        if (current.right != null){
            BSTNode<K, V> successor = current.right;
            if (successor.left != null) successor = successor.left;
            current.key = successor.key;
            current.value = successor.value;
            current = successor;
        }

        BSTNode<K , V> child = (current.left!= null)? current.left: current.right;

        if (current == null){
            root = child;
        } else if (current == current.parent.left) {
            current.parent.left = child;
        }
        else current.parent.right = child;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        Entry(K key, V value) { this.key = key; this.value = value; }

        @Override public K getKey()   { return key; }
        @Override public V getValue() { return value; }

        @Override public V setValue(V newValue) {
            V old = this.value;
            this.value = newValue;
            return old;
        }
    }


    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Map.Entry<K, V>> {
        private final Stack<BSTNode<K, V>> stack = new Stack<>();

        InOrderIterator() { pushLeft(root); }

        private void pushLeft(BSTNode<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() { return !stack.isEmpty(); }

        @Override
        public Map.Entry<K, V> next() {
            BSTNode<K, V> node = stack.pop();
            pushLeft(node.right);
            return new Entry<>(node.key, node.value);
        }
    }

}
