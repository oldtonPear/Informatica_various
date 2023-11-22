public class Arco <T>{
        private Nodo<T> nodo1;
        private Nodo<T> nodo2;
        private double value;
        private boolean bidirezionale;
        Arco(Nodo<T> nodo1, Nodo<T> nodo2, double value, boolean bidirezionale){
            this.nodo1 = nodo1;
            this.nodo2 = nodo2;
            this.value = value;
            this.bidirezionale = bidirezionale;
        }
        @Override
        public String toString() {
            return nodo1.getData() + " " + nodo2.getData() + " " + value;
        }public Nodo<T> getNodo1() {
            return nodo1;
        }
        public Nodo<T> getNodo2() {
            return nodo2;
        }
        public double getValue() {
            return value;
        }
    }