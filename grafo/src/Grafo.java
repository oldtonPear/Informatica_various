import java.util.*;

public class Grafo <T> {
    HashMap<T, LinkedList<T>> map = new HashMap<>();

    private void nuovoVertice(T vertice){
        map.put(vertice, new LinkedList<>());
    }
    public void collega(T vertice1, T vertice2, boolean bidirezionale){
        if(map.get(vertice1) == null) nuovoVertice(vertice1);
        if(map.get(vertice2) == null) nuovoVertice(vertice2);
        if(!bidirezionale) map.get(vertice1).add(vertice2);
        else{
            map.get(vertice2).add(vertice1);
            map.get(vertice1).add(vertice2);
        }
    }

    public String toString(){
        String s = "";
        for (T key : map.keySet()) {
            s += key + ": " + map.get(key).toString();
            s+= "\n";
        }
        return s;
    }

    public boolean esistenzaVertice(T vertice){
        if(map.containsKey(vertice)) return true;
        else{
            for (T key : map.keySet()) {
                if(map.get(key).contains(vertice)) return true;
            }
        }
        return false;
    }

    public int numeroVertici(){
        return map.size();
    }
    public int numeroArchi(){
        int n = 0;
        for (T key : map.keySet()) {
                n += map.get(key).size();
            }
        return n;
    }

    public boolean isFullyConnected(){
        if(numeroArchi() < numeroVertici()*(numeroVertici()-1)) return false;
        return true;
    }

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
    public boolean isConnected(){
        int nArchi;
        if(nArchi == numeroArchi()) return true;
        return true;
    }
}
