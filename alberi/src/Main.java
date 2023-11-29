public class Main {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.add(0, 4);
        tree.add(1, 2);
        tree.add(2, 5);
        tree.add(5, 5);
        

        tree.preOrder();
        tree.printaAlbero();

    }
}
