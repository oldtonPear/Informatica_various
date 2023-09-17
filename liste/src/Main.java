public class Main {
    static ListElement head;

    public static void printaLista(ListElement head){
        ListElement current = head;
         while(current != null){
            System.out.println(current.getData());
            current = current.next;
         }
         System.out.println("");
    }
    //testa indica se voglio inserire in testa o in coda
    public static void inserisci(boolean testa, ListElement element){
        if(testa){
            element.next = head;
            head = element;
        }
        else{
            ListElement current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = element;
            element.next = null;
        }
    }
    public static void main(String[] args) {
        head = new ListElement("ciao");
        ListElement first = new ListElement("sono");
        ListElement second = new ListElement("Christian");
        ListElement third = new ListElement("Torli");
        ListElement fourth = new ListElement("!");

        head.next = first;
        first.next = second;
        second.next = null;

        printaLista(head);
        
        inserisci(true, third);
        printaLista(head);

        inserisci(false, fourth);
        printaLista(head);
    }
}
