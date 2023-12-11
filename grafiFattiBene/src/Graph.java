import java.util.*;
public class Graph <T>{
    private LinkedList<Node<T>> nodes = new LinkedList<>();
    private LinkedList<Edge<T>> edges = new LinkedList<>();

    private HashMap<Node<T>, Double> dist;
    private HashMap<Node<T>, Node<T>> prev;

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
            s += n.getData() + "\n";
        }
        s += "\n";
        for (Edge<T> a : edges) {
            s += a.toString() + "\n";
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

    private LinkedList<Edge<T>> sortEdges(){
        LinkedList<Edge<T>> sortedEdges = new LinkedList<>(); 

        for (Edge<T> edge : edges) {
            sortedEdges.add(new Edge<>(edge.getNodo1(), edge.getNodo2(), edge.getValue(), true));
        }

        for (int i = 0; i < sortedEdges.size(); i++) {
            for (int j = i+1; j < sortedEdges.size(); j++) {
                
                Edge<T> currentEdge = null;
                if(sortedEdges.get(j).getValue() < sortedEdges.get(i).getValue()){
                    currentEdge = sortedEdges.get(i);

                    sortedEdges.set(i, new Edge<>(sortedEdges.get(j).getNodo1(), sortedEdges.get(j).getNodo2(), 
                            sortedEdges.get(j).getValue(), true));

                    sortedEdges.set(j, new Edge<>(currentEdge.getNodo1(), currentEdge.getNodo2(), 
                            currentEdge.getValue(), true));
                }
            }
        }
        return sortedEdges;
    }

    public LinkedList<Edge<T>> kruskal(){
        HashMap<Node<T>, LinkedList<Node<T>>> hm = new HashMap<Node<T>, LinkedList<Node<T>>>();
        LinkedList<Edge<T>> list = new LinkedList<>(); 
        
        LinkedList<Edge<T>> sortedEdges = sortEdges();

        for (Node<T> n : nodes) {
            hm.put(n, new LinkedList<>());
        }
        for (Edge<T> edge : sortedEdges) {
            if(!hm.keySet().contains(edge.getNodo2()) || !hm.keySet().contains(edge.getNodo1())){
                //System.out.println("skip");
                boolean fatto = false;
                if(!hm.keySet().contains(edge.getNodo2()) && !hm.keySet().contains(edge.getNodo1())){
                    //da testare se necessario
                }

                else if(!hm.keySet().contains(edge.getNodo2())){
                    for (Node<T> n1 : hm.keySet()) {
                        
                        for (Node<T> n2 : hm.get(n1)) {
                            if(n2 == edge.getNodo2()){
                                hm.get(n1).addAll(hm.get(edge.getNodo1()));
                                hm.get(n1).add(edge.getNodo1());
                                hm.remove(edge.getNodo1());
                                System.out.println(edge.getNodo1().getData() + " ----> " + edge.getNodo2().getData());
                                fatto = true;
                                break;
                            }
                        }
                        if(fatto) break;
                    }
                    list.add(edge);
                }
                else if(!hm.keySet().contains(edge.getNodo1())){
                    //da testare se necessario
                }
            }
            else if(!hm.get(edge.getNodo1()).contains(edge.getNodo2()) && !hm.get(edge.getNodo1()).contains(edge.getNodo2())){
                hm.get(edge.getNodo1()).addAll(hm.get(edge.getNodo2()));
                hm.get(edge.getNodo1()).add(edge.getNodo2());
                hm.remove(edge.getNodo2());
                System.out.println(edge.getNodo1().getData() + " ----> " + edge.getNodo2().getData());
                list.add(edge);
            }
        }

        System.out.println("\n");
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
