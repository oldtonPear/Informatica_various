public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(10);
        bst.recursiveInsert(5, bst.getRoot());
        bst.recursiveInsert(15, bst.getRoot());
        bst.recursiveInsert(3, bst.getRoot());
        //bst.recursiveInsert(7, bst.getRoot());
        bst.recursiveInsert(13, bst.getRoot());
        bst.recursiveInsert(17, bst.getRoot());
        bst.print();
        bst.recursivedDelete(5, bst.getRoot());
        bst.print();

    }
}
