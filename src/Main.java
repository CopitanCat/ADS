public class Main {

    private static void testArrayList(){
         MyArrayList<Integer> list = new MyArrayList<>();

         // add / size
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Size: " + list.size());

    // add at index
        list.add(15, 1);

    // set
        list.set(0, 99);
        list.set(0, 10); // restore

    // remove by index
        list.remove(4); // remove second 10

        for (int v : list) System.out.println(v);


}

private static void testMyLinkedList() {
    MyLinkedList<String> list = new MyLinkedList<>();

    // add / size / get
    list.add("A");
    list.add("B");
    list.add("C");

    System.out.println("Size: "+ list.size() + "\n" + "Get function: " + list.get(1));

    // add at index
    list.add("z", 0);

    // set
    list.set(0, "X");


    // remove by index
    list.remove(5); // remove second X


    // iterator
    for (String v : list) System.out.println(v);

}
    static public void main(String[] args){
        testArrayList();
        testMyLinkedList();
    }

}
