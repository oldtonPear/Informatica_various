public class BinaryTree <T extends Comparable<T>>{
    
    private Node<T> root;
    private String alberoAppiattito;
    private int nFoglie;

    /**
     * inner class node with "value" as the value stored in the node
     */
    public class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;
        Node(T value, Node<T> left, Node<T> right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public T getValue() {
            return value;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    /**blank constructor */
    public BinaryTree(){
        root = null;
    }
    /**
     * @param root the root node of the tree
     */
    public BinaryTree(T root){
        this.root = new Node<T>(root, null, null);
    }


    /**
     * sets value as root if it does not exsists
     * @param value the value of the node to add
     * @param father the value of the father
     * @param left true if the inserted node should be on the left
     * @return -1 if father is null
     * @return -2 if root is null
     * @return 0
     */
    public int addNode(T value, T father, boolean left){
        if(root == null){
            root = new Node<T>(value, null, null);
            return -2;
        } 
        Node<T> padre = cercaNode(father, root);
        if(padre == null) return -1;
        
        Node<T> n = new Node<T>(value, null, null);
        if(left) padre.setLeft(n);
        if(!left) padre.setRight(n);
        return 0;
    }

    /**
     * prints the tree
     * @return the flat representation of the tree
     */
    public String print(){
        alberoAppiattito = "";
        recursivePrint(root);
        System.out.println(alberoAppiattito);
        return alberoAppiattito;
    }
    /**support method updating "alberoAppiattito" String */
    private void recursivePrint(Node<T> current){

        if(current.getLeft() != null){
            alberoAppiattito += " ( ";
            recursivePrint(current.getLeft());
            alberoAppiattito+= " ) ";
        } 
        
        alberoAppiattito += "" +current.getValue().toString();

        if(current.getRight() != null){
            alberoAppiattito += " ( ";
            recursivePrint(current.getRight());
            alberoAppiattito+= " ) ";
        } 
    }

    /**
     * @param value
     * @param current
     * @return true if a node with the passed value exsists
     * @return false if a node with the passed value does not exsists
     */
    public boolean cerca(T value, Node<T> current){
        if(value.compareTo(current.getValue()) == 0) return true;
        if(current.getLeft() != null) return false || cerca(value, current.getLeft());
        if(current.getRight() != null) return false || cerca(value, current.getRight());
        return false;

    }

    /**
     * @param value
     * @param current
     * @return the node with the passed value
     */
    public Node<T> cercaNode(T value, Node<T> current){
        if (root == null) return null;
        if(value.compareTo(current.getValue()) == 0) return current;
        if(current.getLeft() != null) return cercaNode(value, current.getLeft());
        if(current.getRight() != null) return cercaNode(value, current.getRight());
        return null;
    }

    /**counts the numbers of leaves */
    public int contaFoglie(){
        contaFoglie(root);
        return nFoglie;
    }
    /**updates "nFoglie" */
    private void contaFoglie(Node<T> current){
        if(isFoglia(current)) nFoglie ++;
        if(current.getLeft() != null) contaFoglie(current.getLeft());
        if(current.getRight() != null) contaFoglie(current.getRight());
    }
    
    public Node<T> getRoot() {
        return root;
    }
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * @return true if current is leaf
     * @return false if current is not leaf
     */
    public boolean isFoglia(Node<T> current){
        if(current.getLeft() == null && current.getRight() == null) return true;
        return false;
    }
}
