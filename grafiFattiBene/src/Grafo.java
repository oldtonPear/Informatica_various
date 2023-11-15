import java.util.*;
public class Grafo <T>{
    LinkedList<Nodo<T>> nodi = new LinkedList<>();
    LinkedList<Arco<T>> archi = new LinkedList<>();

    /**collega due vertici e li crea se non esistono, specificare il peso*/
    public void collega(T vertice1, T vertice2, boolean bidirezionale, double peso){
        Nodo<T> v1 = ritornaNodo(vertice1), v2 = ritornaNodo(vertice2);
        
        if(v1 == null){
            v1 = new Nodo<T>(vertice1);
            nodi.add(v1);
        } 
        if(!nodi.contains(v2)){
            v2 = new Nodo<T>(vertice2);
            nodi.add(v2);
        } 

        if(!bidirezionale) archi.add(new Arco<>(v1, v2, peso, bidirezionale));
        else{
            archi.add(new Arco<>(v1, v2, peso, bidirezionale));
            archi.add(new Arco<>(v2, v1, peso, bidirezionale));
        }
    }

    /**ritorna true se il grafo è interamente connesso */
    public boolean isFullyConnected(){
        if(archi.size() < nodi.size()*(nodi.size()-1)) return false;
        return true;
    }
    private Nodo<T> ritornaNodo(T vertice){
        if(nodi.size()<=1) return null;
        for (Nodo<T> n : nodi) {
            if(n.getData() == vertice) return n;
        }
        return null;
    }

    public String toString(){
        String s = "";
        for (Nodo<T> n : nodi) {
            s += n.getData() + " ";
        }
        s += "\n";
        for (Arco<T> a : archi) {
            s += a.toString() + " ";
        }
        return s;
    }
    /**ritorna true se il grafo è connesso */
    public boolean isConnected(){
        for (Nodo<T> firstKey : nodi) {
            for (Nodo<T> secondKey : nodi) {
                if(firstKey != secondKey){
                HashMap<Nodo<T>, Boolean> mapTrovati = new HashMap<>();
                if(!controllaConnessione(firstKey, secondKey, mapTrovati)) return false;
                }
            }
        }
        return true;
    }

    /**restituisce true se esiste una connessione tra due nodi passati */
    private boolean controllaConnessione(Nodo<T> node, Nodo<T> node2, HashMap<Nodo<T>, Boolean> trovati){
        trovati.put(node, true);
        if(esisteArco(node, node2)){
            return true;
        } 
        for (Arco<T> key : archi) {
            if(trovati.get(node) == null){ 
                if(controllaConnessione(key.getNodo1(), node2, trovati)) return true;
                else{
                    //for (Nodo<T> n : map.get(node)) {
                        //if(trovati.get(n) == null) return false || controllaConnessione(n, node2, trovati);
                    //}
                }  
            }
        }
        return false;
    }
    private boolean esisteArco(Nodo<T> nodo1, Nodo<T> nodo2){
        for (Arco<T> arco : archi) {
            if(arco.getNodo1() == nodo1 && arco.getNodo2() == nodo2) return true;
        }
        return false;
    }
    HashMap<Nodo<T>, Double> dist;
    HashMap<Nodo<T>, Nodo<T>> prev;

    /**Aggiorna il i valori a partire da source */
    /*public void Dijkstra(Nodo<T> source){
        double alt = 0d;
        dist = new HashMap<>();
        prev = new HashMap<>();
        ArrayList<Nodo<T>> q = new ArrayList<>();
        for (Nodo<T> vertex : map.keySet()) {
            Double positiveInfinity = Double.POSITIVE_INFINITY;
            dist.put(vertex, positiveInfinity);
            q.add(vertex);
        }
        dist.put(source, 0d);
        
        while(q.size() != 0){
            Nodo<T> u = nodoDistMinore(q);
            q.remove(u);
            for (Nodo<T> neighbor : map.get(u)) {
                if(!q.contains(neighbor)) continue;
                alt = dist.get(u) + 1;
                if(alt < dist.get(neighbor)){
                    dist.put(neighbor, alt);
                    prev.put(neighbor, u);
                }
            }
        }

    }

    private Nodo<T> nodoDistMinore(ArrayList<Nodo<T>> q){
        int pos = 0;
        double minore = dist.get(q.get(0));
        int i =0;
        for (Nodo<T> t : q) {
            if(dist.get(t) < minore){
                pos = i;
                minore = dist.get(t);
            }
            i++;
        }
        return q.get(pos);
    }

    public void printDist() {
        for (Nodo<T> key  : dist.keySet()) {
            System.out.println(key.getData() + " " + dist.get(key));
        }
    }
    public void printPrev() {
        for (Nodo<T> key  : prev.keySet()) {
            System.out.println(key.getData() + " " + prev.get(key).getData());
        }
    }
    */
}
