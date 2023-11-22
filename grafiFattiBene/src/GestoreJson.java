import java.util.LinkedList;
public class GestoreJson <T>{


    private vertex<T>[] nodes;
    private edges<T>[] links; 


    GestoreJson(LinkedList<Nodo<T>> nodi, LinkedList<Arco<T>> archi){
        nodes = new vertex[nodi.size()];
        links = new edges[archi.size()];
        int i = 0;
        for (Arco<T> arco : archi) {
            links[i] = new edges(arco.getNodo1().getData(), arco.getNodo2().getData(), (int)arco.getValue());
            i++;
        }
        i = 0;
        for (Nodo<T> nodo : nodi) {
            nodes[i] = new vertex(nodo.getData(), 1);
            i++;
        }
    }

    class vertex <T>{
        private final T id;
        private final int group;
        vertex(T id, int group){
            this.id =id;
            this.group = group;
        }
        public T getId() {
            return id;
        }
        public int getGroup() {
            return group;
        }
    }
    class edges<T>{
        private final T source, target;
        private int value;
        edges(T source, T target, int value){
            this.source = source;
            this.target = target;
            this.value = value;
        }
        public T getSource() {
            return source;
        }
        public T getTarget() {
            return target;
        }
        public int getValue() {
            return value;
        }
    }
}
