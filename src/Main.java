public class Main {
    static public void main(String[] args){
        MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
        arrayList.add(21);
        arrayList.add(70);
        arrayList.add(90);
        arrayList.add(100);
        for (int i =0 ; i<4;i++){
        System.out.println(arrayList.get(i));}
    }

}
