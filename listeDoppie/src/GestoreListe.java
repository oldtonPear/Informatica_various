public class GestoreListe <T extends Comparable>   {
    ListElement <T> head = null;
    
    /**cerca se l'elemento è presente nella lista */
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
    /**printa la lista partendo dalla head passata */
    public void printaLista(ListElement <T> head){
        ListElement <T> current = head;
         while(current != null){
            System.out.println(current.getData());
            current = current.next;
         }
         System.out.println("");
    }
    /**inserisci un elemento in testa */
    public void inserisciInTesta(ListElement <T> element){
        element.next = head;
        head = element;
        head.prev = null;
    }
    /**inserisce un elemento in coda */
    public void inserisciInCoda(ListElement <T> element){
        ListElement <T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = element;
        element.next = null;
        element.prev = current;
    }
    /**inseirsce un elemento alla posizione passata */
    public void inserisciInMezzo(ListElement <T> element, int pos){
        if(pos == 0){
            inserisciInTesta(element);
        }
        else{
            ListElement <T> current = head;
            for (int i = 0; i <= pos && current != null; i++) {
                current = current.next;
            }
            if(current == null) inserisciInCoda(element);
            else{
                element.next = current.next;
                current.next.prev = element;

                current.next = element;
                element.prev = current;
                
                
            }
        }
    }
    /**rimuove l'elemento in head */
    public void rimuoviHead(){
        head = head.next;
        head.prev = null;
    }
    
    public void rimuoviCoda(){
        ListElement <T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.prev.next = null;
        current = null;
    }
    /**rimuove il nodo alla posizione n */
    public void rimuoviNodo(int pos){
        if(pos == 0) rimuoviHead();
        else{
            ListElement <T> current = head;
            for (int i = 0; i < pos && current.next != null; i++) {
                current = current.next;
            }
            if(current == null) rimuoviCoda();
            else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current = null;
            }
            
        }
    }
    /**rimuove il primo nodo che ha come dato il valore passato */
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
            current.prev = previous;
        }
    }
    /**crea un nuovo nodo alla posizione pos */
    public void nuovoNodo(T data, int pos){
        ListElement <T> nuovo = new ListElement<>(data);
        //inserisciInMezzo(nuovo, pos);
        inserimentoOrdinato(nuovo);
    }
    
    public ListElement <T> getHead() {
        return head;
    }

    public void controllaAvanti(){
        ListElement <T> current = head;
        while(current.next != null){
            System.out.print(" -> "+ current.getData());
            current = current.next;
        }
        System.out.print(" -> "+ current.getData() + " -> null");
    }

    public void controllaIndietro(){
        ListElement <T> current = head;
        while(current.next != null){
            current = current.next;
        }
        System.out.print("null ");
        if(current == head) System.out.print(current.getData());
        while(current != null){
            System.out.print(" <- "+ current.getData());
            current = current.prev;
        }
        System.out.print(" <- " + head.getData() + " <-");
        
    }

    public void inserimentoOrdinato(ListElement element){
        if(head == null) inserisciInTesta(element);
        else if(head.next == null){
            head.next = element;
            element.prev = head;
            element.next = null;

        }
        else{
            ListElement <T> current = head;
            if(current.next.getData().compareTo(element.getData()) >0 && current == head){
                    inserisciInTesta(element);
            }
            else while(current.next != null){
                if(current.next.getData().compareTo(element.getData()) >0){
                    element.prev = current.prev;
                    element.next = current;
                    
                    current.prev = element;
                    element.prev.next = element;
                    
                    break;
                }
                current = current.next;
            }
            if(current.next == null) inserisciInCoda(element);
        }
    }

}
