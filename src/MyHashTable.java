
public class MyHashTable<K, V>{
  private static class HashNode<K, V>{
    private K key;
    private V value;
    private HashNode<K, V> next;
    public HashNode(K key , V value){
      this.key = key;
      this.value = value;
    }

    @Override 
    public String toString(){
      return "{" + key +" "+ value+ "}";
    }
  }
  private HashNode<K, V>[] chainArray;
  private int M = 11;
  private int size;

  public MyHashTable(){
    chainArray = new HashNode[M];
  }
  public MyHashTable(int M){
    this.M = M;
    chainArray = new HashNode[M];
  }

  private int hash(K key){
    if (key == null) return 0;

    String str = key.toString();
    int h = 0;

    for (int i = 0; i < str.length(); i++) {
      h = h * 31 + str.charAt(i);
    }
    return (h&Integer.MAX_VALUE) % M;
  }

  public void put(K key, V value){
    int index = hash(key);
    HashNode<K, V> current  = chainArray[index];

    if (current != null){
      if (current.key.equals(key)){
        current.value = value;
      }
      current = current.next;
    }
    size++;
    HashNode<K, V> newNode = new HashNode<>(key, value);
    newNode.next = chainArray[index];
    chainArray[index] = newNode;
  }
  public V get(K key){
    int index = hash(key);
    HashNode<K, V> current = chainArray[index];

    while (current != null){
      if (current.key.equals(key)){
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  public int size(){
    return size;
  }

  public V remove(K key){
    int index = hash(key);
    HashNode<K, V> current = chainArray[index];
    HashNode<K, V> prev = null;

    while (current != null){
      if (current.key.equals(key)){
        if (prev == null) {
          chainArray[index] = current.next;
        }else {
          prev.next = current.next;
        }
        size--;
        return current.value;
      }
      prev = current;
      current = current.next;
    }
    return null;
  }

  public boolean contains(V value){
    for (int i =0 ; i<M ; i++){
      HashNode<K, V> current = chainArray[i];
      while (current != null) {
        if (current.value.equals(value)) return true;
        current = current.next;
      }
    }
    return false;
  }

  public K getKey(V value) {
    for (int i = 0; i < M; i++) {
      HashNode<K, V> current = chainArray[i];
      while (current != null) {
        if (current.value.equals(value)) return current.key;
        current = current.next;
      }
    }
    return null;
  }
}
