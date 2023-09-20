import java.net.http.WebSocket.Listener;

public class GestoreListe <T>{
    ListElement <T> head;
    
    /*** cerca se l'elemento è presente nella lista */
    public int cercaElemento(T elemento){
        int i = 0;
        ListElement <T> current = head;
        while(current != null){
            if(current.getData() == elemento) return i;
            i++;
            current = current.next;
        }
        return -1;
    }
    /***printa la lista partendo dalla head passata */
    public void printaLista(ListElement <T> head){
        ListElement <T> current = head;
         while(current != null){
            System.out.println(current.getData());
            current = current.next;
         }
         System.out.println("");
    }
    /***inserisci un elemento in testa */
    public void inserisciInTesta(ListElement <T> element){
        element.next = head;
        head = element;
    }
    /***inserisce un elemento in coda */
    public void inserisciInCoda(ListElement <T> element){
        ListElement <T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = element;
        element.next = null;
    }
    /***inseirsce un elemento alla posizione passata */
    public void inserisciInMezzo(ListElement <T> element, int pos){
        if(pos == 0){
            element.next = head;
            head = element;
        }
        else{
            ListElement <T> current = head;
            ListElement <T> previous = null;
        for (int i = 0; i <= pos && current != null; i++) {
            previous = current;
            current = current.next;
        }
            previous.next = element;
            element.next = current;
        }
    }
    /***rimuove l'elemento in head */
    public void rimuoviHead(){
        head = head.next;
    }
    /***rimuove il nodo alla posizione n */
    public void rimuoviNodo(int pos){
        if(pos == 0) rimuoviHead();
        else{
            ListElement <T> current = head;
            ListElement <T> previous = null;
            for (int i = 0; i < pos && current.next != null; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            current = null;
        }
    }
    /***rimuove il primo nodo che ha come dato il valore passato */
    public void rimuoviPerValore(ListElement <T> element, T valore){
        ListElement <T> current = head;
        ListElement <T> previous = null;
        int i = 0;
        while(current.next != null){
            if(current.getData() == valore){
                rimuoviNodo(i);
            }
            i++;
            previous = current;
            current = current.next;
        }
    }
    /***crea un nuovo nodo alla posizione pos */
    public void nuovoNodo(T data, int pos){
        ListElement <T> nuovo = new ListElement<>(data);
        inserisciInMezzo(nuovo, pos);
    }
    
    public ListElement <T> getHead() {
        return head;
    }
}
