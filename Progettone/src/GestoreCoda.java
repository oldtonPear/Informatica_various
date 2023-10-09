import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class GestoreCoda {

    public class Node {
        private File data;
        private Node next;
    
        Node(File data){
            this.data = data;
            next = null;
        }
        public Node getNext() {
        return next;
        }
        public File getData() {
            return data;
        }
    }

    private Node head;
    private Node tail;
    GestoreFile gesFile = new GestoreFile();

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
    /***inserisce un nuovo nodo nella coda */
    public void inserimento(File f){
        Node n = new Node(f);
        if(head == null && tail == null){
            head = n;
            tail = n;
        }
        else{
            tail.next = n;
            tail = n;
        }
    }

    /***rimuove un nodo dalla coda */
    public void rimozione(){
        if(head == null) System.out.println("Non sono presenti elementi");
        else if(head.next == null) head = null;
        else{
            head = head.next;
        }
    }
    public void creaCoda(){
        ArrayList<String> listaFile = gesFile.getTxt();
        for (String string : listaFile) {
            File f = new File(string);
            inserimento(f);
        }
    }
    public void printaCoda(){
        Node current = head;
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println("");
    }
    
    
    /* con coda rovescia
    public void creaFileStampa(){
        String s, result = "";
        FileReader r;
        BufferedReader reader;
        while(getLast() != null){
            try{
                r = new FileReader(getLast().data);
                reader = new BufferedReader(r);
                result +="*****INIZIO*****" + "\n";
                s = reader.readLine();
			    while(s!=null){
                    result += s + "\n";
				    s=reader.readLine();
			    }
            result +="***** FINE *****" + "\n";
            }catch(Exception e){
                System.out.println(e.getCause());
            }
            gesFile.scriviSuOutput(result);
            rimozione();
        }
    }
    */
}