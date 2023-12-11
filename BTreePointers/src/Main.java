public class Main {
 
    public static void main(String[] args) {
        /*BinaryTree<String> tree = new BinaryTree<>("Catanzaro");
        tree.addNode("Trapani", "Catanzaro", true);
        tree.addNode("Gallipoli", "Catanzaro", false);
        tree.addNode("Avellino", "Trapani", false);
        tree.addNode("Benevento", "Trapani", true);
        tree.print();
        System.out.println(tree.cerca("Trapani", tree.getRoot()));
        System.out.println(tree.contaFoglie());*/
        BinaryTree<Integer> tree = new BinaryTree<>();
        int []elements = {1,2,3,4,5,6,7};
        BSTBuilderRecursive(elements, tree, 0, elements.length, 0,0, true);
        tree.print();
    }

    public static void BSTBuilderRecursive(int[] elements, BinaryTree<Integer> tree, int min, int max, int index, int current, boolean left){
        int mid = (int) (min+max)/2;
       
        if (index <= elements.length){
            System.out.println(index + ")"+ mid + " " +elements[mid]);
            tree.addNode(elements[mid], elements[current], left);
            BSTBuilderRecursive(elements, tree, min, mid, index * 2 + 1, mid, true);
            BSTBuilderRecursive(elements, tree, mid, max, index * 2 + 2, mid, false);
        }
    }
}
