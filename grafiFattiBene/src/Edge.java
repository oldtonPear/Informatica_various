public class Edge <T>{
        private Node<T> nodo1;
        private Node<T> nodo2;
        private double value;
        private boolean bidirezionale;
        Edge(Node<T> nodo1, Node<T> nodo2, double value, boolean bidirezionale){
            this.nodo1 = nodo1;
            this.nodo2 = nodo2;
            this.value = value;
            this.bidirezionale = bidirezionale;
        }
        @Override
        public String toString() {
            return nodo1.getData() + " " + nodo2.getData() + " " + value;
        }public Node<T> getNodo1() {
            return nodo1;
        }
        public Node<T> getNodo2() {
            return nodo2;
        }
        public double getValue() {
            return value;
        }
    }