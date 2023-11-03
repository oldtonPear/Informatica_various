import java.util.*;

public class Grafo <T> {
    private HashMap<T, LinkedList<T>> map = new HashMap<>();
    private HashMap<Integer, LinkedList<T>> cricche = new HashMap<>();

    /**crea un nuovo vertice */
    private void nuovoVertice(T vertice){
        map.put(vertice, new LinkedList<>());
    }

    /**collega due vertici e li crea se non esistono */
    public void collega(T vertice1, T vertice2, boolean bidirezionale){
        if(map.get(vertice1) == null) nuovoVertice(vertice1);
        if(map.get(vertice2) == null) nuovoVertice(vertice2);
        if(!bidirezionale) map.get(vertice1).add(vertice2);
        else{
            map.get(vertice2).add(vertice1);
            map.get(vertice1).add(vertice2);
        }
    }

    /**restituisce una rappresentazione in stringa del grafo */
    public String toString(){
        String s = "";
        for (T key : map.keySet()) {
            s += key + ": " + map.get(key).toString();
            s+= "\n";
        }
        return s;
    }

    /**ritorna true se il vertice passato esiste */
    public boolean esistenzaVertice(T vertice){
        if(map.containsKey(vertice)) return true;
        else{
            for (T key : map.keySet()) {
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
        for (T key : map.keySet()) {
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
    public T maxOrder(){
        int maxOrder = 0;
        T node = null;
        for (T key : map.keySet()) {
            if(map.get(key).size() > maxOrder){
                maxOrder = map.get(key).size(); 
                node=key;
            } 
        }
        return node;
    }

    /**ritorna il vertice di ordine minore */
    public T minOrder(){
        int minOrder = -1;
        T node = null;
        for (T key : map.keySet()) {
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
        for (T firstKey : map.keySet()) {
            for (T secondKey : map.keySet()) {
                if(firstKey != secondKey){
                HashMap mapTrovati = new HashMap<T, Boolean>();
                if(!controllaConnessione(firstKey, secondKey, mapTrovati)) return false;
                }
            }
        }
        return true;
    }

    /**restituisce true se esiste una connessione tra due nodi passati */
    private boolean controllaConnessione(T node, T node2, HashMap<T, Boolean> trovati){
        trovati.put(node, true);
        if(map.get(node).contains(node2)){
            return true;
        } 
        for (T key : map.get(node)) {
            if(trovati.get(key) == null){ 
                if(controllaConnessione(key, node2, trovati)) return true;
                else{
                    for (T n : map.get(node)) {
                        if(trovati.get(n) == null) return false || controllaConnessione(n, node2, trovati);
                    }
                }  
            }
        }
        return false;
    }
    private HashMap<T, Boolean> esplorati = new HashMap<>();
    public HashMap<Integer, LinkedList<T>> cercaCricche(){
        for (T firstKey : map.keySet()) {
            for (T element : map.get(firstKey)) {
                if(!map.containsKey(element)) break;
            }
        }


        return cricche;
    }
}