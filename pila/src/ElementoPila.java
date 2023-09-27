public class ElementoPila {
    private char c;
    private ElementoPila next;

    ElementoPila(char c){
        this.c = c;
    }

    
    public ElementoPila getNext() {
        return next;
    }
    public void setNext(ElementoPila next) {
        this.next = next;
    }
    public char getC() {
        return c;
    }
    public void setC(char c) {
        this.c = c;
    }
}
