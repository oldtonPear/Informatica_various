public class Main {
    public static void main(String[] args) {
        MyArraylist<Integer> list = new MyArraylist<>(10);
        /*list.add(10);
        list.add(5);
        //list.printa();
        list.remove(0);
        list.printa();
        */
        list.get(0);
        list.set(5, 10);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list.get(i));
        }
    }
}
