public class BinaryTree <T extends Comparable<T>>{
    
    private Node<T> root;
    private String alberoAppiattito;

    private class Node<T>{
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


    public BinaryTree(){
        root = null;
    }
    public BinaryTree(T root){
        this.root = new Node<T>(root, null, null);
    }


    /**
     * 
     * @param value the value of the node to add
     * @param father the value of the father
     * @param left true if the inserted node should be on the left
     * @return -1 if father is null
     * @return -2 if root is null
     * @return 0
     */
    public int addNode(T value, T father, boolean left){
        Node<T> padre = cercaNode(father, root);
        if(padre == null) return -1;
        if(root == null) return -2;
        Node<T> n = new Node<T>(value, null, null);
        if(left) padre.setLeft(n);
        if(!left) padre.setRight(n);
        return 0;
    }

    public String print(){
        alberoAppiattito = "";
        recursivePrint(root);
        
        System.out.println(alberoAppiattito);
        return alberoAppiattito;
    }
    private void recursivePrint(Node<T> current){
        
        if(current.getLeft() != null){
            recursivePrint(current.getLeft());
        } 
        
        alberoAppiattito += " " +current.getValue().toString();

        if(current.getRight() != null){
            recursivePrint(current.getRight());
        } 
    }

    public boolean cerca(T value, Node<T> current){
        if(value.compareTo(current.getValue()) == 0) return true;
        if(current.getLeft() != null) return false || cerca(value, current.getLeft());
        if(current.getRight() != null) return false || cerca(value, current.getRight());
        return false;

    }

    private Node<T> cercaNode(T value, Node<T> current){
        if(value.compareTo(current.getValue()) == 0) return current;
        if(current.getLeft() != null) return cercaNode(value, current.getLeft());
        if(current.getRight() != null) return cercaNode(value, current.getRight());
        return null;
    }


    public int contaFoglie(){
        throw new UnsupportedOperationException("Unimplemented method 'contaFoglie'");
    }
    
    public Node<T> getRoot() {
        return root;
    }
}
