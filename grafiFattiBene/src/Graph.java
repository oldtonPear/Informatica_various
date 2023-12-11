import java.util.*;
public class Graph <T>{
    private LinkedList<Node<T>> nodes = new LinkedList<>();
    private LinkedList<Edge<T>> edges = new LinkedList<>();

    private HashMap<Node<T>, Boolean> mapTrovati = new HashMap<>();

    /**collega due vertici e li crea se non esistono, specificare il peso*/
    public void collega(T vertice1, T vertice2, boolean bidirezionale, double peso){
        Node<T> v1 = ritornaNodo(vertice1), v2 = ritornaNodo(vertice2);
        
        if(v1 == null){
            v1 = new Node<T>(vertice1);
            nodes.add(v1);
        } 
        if(!nodes.contains(v2)){
            v2 = new Node<T>(vertice2);
            nodes.add(v2);
        } 

        if(!bidirezionale) edges.add(new Edge<>(v1, v2, peso, bidirezionale));
        else{
            edges.add(new Edge<>(v1, v2, peso, bidirezionale));
            edges.add(new Edge<>(v2, v1, peso, bidirezionale));
        }
    }

    /**ritorna true se il Graph è interamente connesso */
    public boolean isFullyConnected(){
        if(edges.size() < nodes.size()*(nodes.size()-1)) return false;
        return true;
    }
    private Node<T> ritornaNodo(T vertice){
        if(nodes.size()<=1) return null;
        for (Node<T> n : nodes) {
            if(n.getData() == vertice) return n;
        }
        return null;
    }

    public String toString(){
        String s = "";
        for (Node<T> n : nodes) {
            s += n.getData() + " ";
        }
        s += "\n";
        for (Edge<T> a : edges) {
            s += a.toString() + " ";
        }
        return s;
    }

    /**ritorna true se il Graph è connesso */
    public boolean isConnected(){
        for (Node<T> firstKey : nodes) {
            for (Node<T> secondKey : nodes) {
                if(firstKey != secondKey){
                mapTrovati = new HashMap<>();
                if(!areConnected(firstKey, secondKey)) return false;
                }
            }
        }
        return true;
    }

    /**restituisce true se esiste una connessione tra due nodes passati */
    private boolean areConnected(Node<T> node, Node<T> node2){
        mapTrovati.put(node, true);
        if(esisteArco(node, node2)){
            return true;
        } 
        for (Edge<T> key : archiChePartonoDa(node)) {
            if(mapTrovati.get(key.getNodo2()) == null){ 
                if(areConnected(key.getNodo2(), node2)) return true;
                else{
                    for (Node<T> n : nodes) {
                        if(mapTrovati.get(n) == null) return false || areConnected(n, node2);
                    }
                }  
            }
        }
        return false;
    }

    private boolean esisteArco(Node<T> nodo1, Node<T> nodo2){
        for (Edge<T> Edge : edges) {
            if(Edge.getNodo1() == nodo1 && Edge.getNodo2() == nodo2) return true;
        }
        return false;
    }
    HashMap<Node<T>, Double> dist;
    HashMap<Node<T>, Node<T>> prev;

    /**Aggiorna il i valori a partire da source */
    public void Dijkstra(Node<T> source){
        double alt = 0d;
        dist = new HashMap<>();
        prev = new HashMap<>();
        ArrayList<Node<T>> q = new ArrayList<>();
        for (Node<T> vertex : nodes) {
            Double positiveInfinity = Double.POSITIVE_INFINITY;
            dist.put(vertex, positiveInfinity);
            q.add(vertex);
        }
        dist.put(source, 0d);
        
        while(q.size() != 0){
            Node<T> u = nodoDistMinore(q);
            q.remove(u);
            for (Edge<T> n : archiChePartonoDa(u)) {
                Node<T> neighbor = n.getNodo2();
                if(!q.contains(neighbor)) continue;
                alt = dist.get(u) + n.getValue();
                if(alt < dist.get(neighbor)){
                    dist.put(neighbor, alt);
                    prev.put(neighbor, u);
                }
            }
        }
    }

    public boolean belmanFord(Node<T> source){
        dist = new HashMap<>();
        prev = new HashMap<>();
        ArrayList<Node<T>> q = new ArrayList<>();
        for (Node<T> vertex : nodes) {
            Double positiveInfinity = Double.POSITIVE_INFINITY;
            dist.put(vertex, positiveInfinity);
            q.add(vertex);
        }
        dist.put(source, 0d);

        for (int i = 0; i < q.size()-1; i++) {
            for (Edge<T> edge : edges) {
                if(dist.get(edge.getNodo2()) > dist.get(edge.getNodo1()) + edge.getValue()){
                    dist.put(edge.getNodo2(), dist.get(edge.getNodo1()) + edge.getValue());
                    prev.put(edge.getNodo2(), edge.getNodo1());
                }
            }
            for (Edge<T> edge : edges) {
                if(dist.get(edge.getNodo2()) > dist.get(edge.getNodo1()) + edge.getValue()){
                    return false;
                }
            }
        }
        return true;
    }

    public LinkedList<Edge<T>> kruskal(){
        LinkedList<Edge<T>> list = new LinkedList<>(); 
        
        return list;
    }

    private Edge<T> getEdgeWith(Node<T> node1, Node<T> node2){
        for (Edge<T> edge : edges) {
            if(edge.getNodo1() == node1 && edge.getNodo2() == node2) return edge;
        }
        return null;
    }

    private void printaHashMap(HashMap <Node<T>, LinkedList<Node<T>>> hm){
        for (Node<T> key : hm.keySet()) {
            System.out.print(key.getData() + ": ");
            for (Node<T> key2 : hm.get(key)) {
                System.out.print(key2.getData() + " ");
            }
            System.out.println("");
        }
    }

    private LinkedList<Edge<T>> archiChePartonoDa(Node<T> Node){
        LinkedList<Edge<T>> a = new LinkedList<>();
        for (Edge<T> Edge : edges) {
            if(Edge.getNodo1() == Node) a.add(Edge);
        }
        return a;
    }

    private Node<T> nodoDistMinore(ArrayList<Node<T>> q){
        int pos = 0;
        double minore = dist.get(q.get(0));
        int i =0;
        for (Node<T> t : q) {
            if(dist.get(t) < minore){
                pos = i;
                minore = dist.get(t);
            }
            i++;
        }
        return q.get(pos);
    }

    public Node<T> firstVertex(){
        return nodes.getFirst();
    }
    
    public void printDist() {
        for (Node<T> key  : dist.keySet()) {
            System.out.println(key.getData() + " " + dist.get(key));
        }
    }
    public void printPrev() {
        for (Node<T> key  : prev.keySet()) {
            System.out.println(key.getData() + " " + prev.get(key).getData());
        }
    }
    public LinkedList<Node<T>> getNodi() {
        return nodes;
    }
    public LinkedList<Edge<T>> getArchi() {
        return edges;
    }

    
}
