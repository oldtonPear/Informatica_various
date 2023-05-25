public class Main {
    public static void main(String[] args) {
        MyArraylist<String> list = new MyArraylist<>(String.class);
        
        list.add("10");
        list.add("5");
        list.remove(0);
        list.printa();
        
    }
}
