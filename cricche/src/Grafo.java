import java.util.*;

public class Grafo <T> {
    private HashMap<Nodo<T>, LinkedList<Nodo<T>>> map = new HashMap<>();

    /**collega due vertici e li crea se non esistono, specificare il peso*/
    public void collega(T vertice1, T vertice2, boolean bidirezionale, double peso){
        Nodo<T> v1 = ritornaNodo(vertice1), v2 = ritornaNodo(vertice2);
        
        map.putIfAbsent(v1, new LinkedList<>());
        map.putIfAbsent(v2, new LinkedList<>());
        if(!bidirezionale) map.get(v1).add(v2);
        else{
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
    }

    

    /**collega due vertici e li crea se non esistono, peso = 1*/
    public void collega(T vertice1, T vertice2, boolean bidirezionale){
        Nodo<T> v1 = ritornaNodo(vertice1), v2 = ritornaNodo(vertice2);
        
        map.putIfAbsent(v1, new LinkedList<>());
        map.putIfAbsent(v2, new LinkedList<>());
        if(!bidirezionale) map.get(v1).add(v2);
        else{
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
    }
    private Nodo<T> ritornaNodo(T vertice){
        Nodo<T> v = null;
        for (Nodo<T> key : map.keySet()) {
            if(key.getData() == vertice) v = key;
        }
        if(v == null) v = new Nodo<>(vertice);
        return v;
    }

    /**restituisce una rappresentazione in stringa del grafo */
    public String toString(){
        String s = "";
        for (Nodo<T> key : map.keySet()) {
            s += key.getData() + ": ";
            for (Nodo<T> element : map.get(key)) {
                s += " " + element.getData() + " " + 1 + "|";
            }
            s+= "\n";
        }
        return s;
    }

    /**ritorna true se il vertice passato esiste */
    public boolean esistenzaVertice(T vertice){
        if(map.containsKey(vertice)) return true;
        else{
            for (Nodo<T> key : map.keySet()) {
                if(map.get(key).contains(vertice)) return true;
            }
        }
        return false;
    }

    /**ritorna il numero di vertici del grafo */
    public int numeroVertici(){
        return map.size();
    }

    /**ritorna il numero di vertici del grafo passato */
    public int numeroVertici(HashMap<T, LinkedList<T>> map2){
        return map2.size();
    }

    /**ritorna il numero di archi del grafo */
    public int numeroArchi(){
        int n = 0;
        for (Nodo<T> key : map.keySet()) {
                n += map.get(key).size();
            }
        return n;
    }

    /**ritorna il numero di archi del grafo passato */
    public int numeroArchi(HashMap<T, LinkedList<T>> map2){
        int n = 0;
        for (T key : map2.keySet()) {
                n += map2.get(key).size();
            }
        return n;
    }

    /**ritorna true se il grafo è interamente connesso */
    public boolean isFullyConnected(){
        if(numeroArchi() < numeroVertici()*(numeroVertici()-1)) return false;
        return true;
    }

    /**ritorna true se il grafo passato è interamente connesso */
    public boolean isFullyConnected(HashMap<T, LinkedList<T>> map2){
        if(numeroArchi(map2) < numeroVertici(map2)*(numeroVertici(map2)-1)) return false;
        return true;
    }

    /**ritorna il vertice di ordine maggiore */
    public Nodo<T> maxOrder(){
        int maxOrder = 0;
        Nodo<T> node = null;
        for (Nodo<T> key : map.keySet()) {
            if(map.get(key).size() > maxOrder){
                maxOrder = map.get(key).size(); 
                node=key;
            } 
        }
        return node;
    }

    /**ritorna il vertice di ordine minore */
    public Nodo<T> minOrder(){
        int minOrder = -1;
        Nodo<T> node = null;
        for (Nodo<T> key : map.keySet()) {
            if(minOrder == -1) minOrder = map.get(key).size(); 
            if(map.get(key).size() < minOrder){
                minOrder = map.get(key).size(); 
                node=key;
            } 
        }
        return node;
    }

    /**ritorna true se il grafo è connesso */
    public boolean isConnected(){
        for (Nodo<T> firstKey : map.keySet()) {
            for (Nodo<T> secondKey : map.keySet()) {
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
        if(map.get(node).contains(node2)){
            return true;
        } 
        for (Nodo<T> key : map.get(node)) {
            if(trovati.get(key) == null){ 
                if(controllaConnessione(key, node2, trovati)) return true;
                else{
                    for (Nodo<T> n : map.get(node)) {
                        if(trovati.get(n) == null) return false || controllaConnessione(n, node2, trovati);
                    }
                }  
            }
        }
        return false;
    }
    HashMap<Nodo<T>, Double> dist;
    HashMap<Nodo<T>, Nodo<T>> prev;

    /**Aggiorna il i valori a partire da source */
    public void Dijkstra(Nodo<T> source){
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
    
}