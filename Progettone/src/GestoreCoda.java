import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class GestoreCoda {
    private Node head;
    GestoreFile gesFile = new GestoreFile();
    
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getLast(){
        if(head == null){
            System.out.println("Non sono presenti elementi");
            return null;
        } 
        else if(head.getNext() == null) return head;
        else{
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            return current;
        }
    }

    public void inserimento(File f){
        Node n = new Node(f);
        if(head == null) head = n;
        else{
            n.setNext(head);
            head = n;
        }
    }
    public void rimozione(){
        if(head == null) System.out.println("Non sono presenti elementi");
        else if(head.getNext() == null) head = null;
        else{
            Node prev = null;
            Node current = head;
            while(current.getNext() != null){
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            current = null;
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
                System.out.println(current.getData());
                current = current.getNext();
            }
            System.out.println("");
    }
    public void creaFileStampa(){
        String s, result = "";
        FileReader r;
        BufferedReader reader;
        while(getLast() != null){
            try{
                r = new FileReader(getLast().getData());
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
}