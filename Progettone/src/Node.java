import java.io.*;
public class Node {
    private File data;
    private Node next;

    Node(File data){
        this.data = data;
        next = null;
    }

    public File getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    
}
