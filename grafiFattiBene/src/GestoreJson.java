import java.util.LinkedList;
public class GestoreJson <T>{


    private vertex<T>[] nodes;
    private edges<T>[] links; 


    GestoreJson(LinkedList<Node<T>> nodi, LinkedList<Edge<T>> archi){
        nodes = new vertex[nodi.size()];
        links = new edges[archi.size()];
        int i = 0;
        for (Edge<T> Edge : archi) {
            links[i] = new edges(Edge.getNodo1().getData(), Edge.getNodo2().getData(), (int)Edge.getValue());
            i++;
        }
        i = 0;
        for (Node<T> Node : nodi) {
            nodes[i] = new vertex(Node.getData(), 1);
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
