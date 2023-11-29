import java.util.ArrayList;
import java.util.Stack;

public class BTree <T> {
    private ArrayList<T> albero = new ArrayList<>();

    private ArrayList<T> arrListPreOrder = new ArrayList<>();


    /**
     * 
     * @param index posizione alla quale aggiungere
     * @param value valore da aggiungere
     * @return 0 se l'inserimento è andato a buon fine
     * @return -1 se la posizione è già occupata
     * @return -2 se non esiste un padre
     */
    public int add(int index, T value){
        if(search(value) != -1) return -1;
        if(esistePadre(index) == -1 ||
         (esistePadre(index) == -2) && index != 0) return -2;
        for (int i = 0; i < index; i++) {
            if(albero.size() <= i) albero.add(null);
        }
        albero.add(index, value);
        return 0;
    }

    /**
     * 
     * @param value valore all'interno del'albero
     * @return index of value
     * @return -1 se non esiste
     */
    public int search(T value){
        for (T t : albero) {
            if(t == value) return albero.indexOf(value);
        }
        return -1;
    }

    /**
     * restituisce il figio sinistro del value passato
     * @param value valore all'interno del'albero
     * @return index of leftChild
     * @return -1 se non esiste un figio sinistro
     * @return -2 se non esiste un nodo con value
     */
    int leftChild(T value){
        if(search(value) == -1) return -2;
        if(albero.size() <= search(value)*2+1 || albero.get(search(value)*2+1) == null) return -1;
        return search(value)*2+1;
    }

    /**
     * restituisce il figio destro del value passato
     * @param value valore all'interno del'albero
     * @return index of rightChild
     * @return -1 se non esiste un figio destro
     * @return -2 se non esiste un nodo con value
     */
    int rightChild(T value){
        if(search(value) == -1) return -2;
        if(albero.size() <= search(value)*2+2 || albero.get(search(value)*2+2) == null) return -1;
        return search(value)*2+2;
    }


    /**
     * restituisce la posizione del padre
     * @param index indice al quale cercare il padre
     * @return 0 se il padre esiste
     * @return -1 se il padre non esiste
     * @return -2 se l'albero è vuoto
     */
    public int esistePadre(int index){
        if(albero.size() == 0) return -2;
        if(albero.get((index-1)/2) == null) return -1;
        return 0;
    }

    /**
     * esplora l'albero in preOrder
     * @return arrayList con l'albero esplorato in preOrder
     */
    public ArrayList<T> preOrder(){
       preOrderRicorsivo(albero.get(0));
       preOrderIterattivo();
       return arrListPreOrder;

    }

    /**
     * preOrder ricorsivo
     * @param node
     */
    private void preOrderRicorsivo(T node){
        if(albero.get(search(node)) != null){
            arrListPreOrder.add(node);
            if(leftChild(node) != -1) preOrderRicorsivo(albero.get(leftChild(node)));
            if(rightChild(node) != -1) preOrderRicorsivo(albero.get(rightChild(node)));
        }
    }

    /**
     * preOrder iterattivo
     */
    private void preOrderIterattivo(){
        Stack<T> stack = new Stack<>();
        stack.push(albero.get(0));
        while(!stack.empty()){
            T node = stack.pop();
            if(node != null){
                arrListPreOrder.add(node);
                
                if(leftChild(node) != -1) stack.push(albero.get(leftChild(node)));
                if(rightChild(node) != -1) stack.push(albero.get(rightChild(node)));
            }
        }
    }

    /**
     * printa l'albero
     */
    public void printaAlbero(){
        for (T t : albero) {
            System.out.print(t + " ");
        }
    }
}
