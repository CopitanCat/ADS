public class Main {
    static public void main(String[] args){
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(21);
        arrayList.add(70);
        arrayList.add(90);
        arrayList.add(100,2);


        for (Object i : arrayList){
        System.out.println(i);}
    }

}
