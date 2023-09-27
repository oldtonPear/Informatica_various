public class Pila {
    String value;
    ElementoPila head;

    /**
     * implementazione di una pila mediante liste
     * controllo se un espressione matematica che contiene parentesi è corretta dal punto di vista di quest'ultime
     * verifico che ad ogni parentesi aperta ci sia una parentesi chiusa secondo l'ordine (, [, {
     * @see ElementoPila
     * @param value
     * 
     */
    Pila(String value){
        this.value = value;
        creaPila();
    }

    public void creaPila(){
        int i = 0;
        char c = value.charAt(0);
        while(i < value.length()-1){
            if(c == '{' || c == '[' || c == '('){
                push(c);
            }
            else if(c == '}' || c == ']' || c == ')'){
                if(peek() != null){
                    if(c == '}' && peek().getC() == '{' ){
                        pop();
                    }
                    if(c == ']' && peek().getC() == '[' ){
                        pop();
                    }
                    else if(c == ')' && peek().getC() == '(' ){
                        pop();
                    }
                }
                else{
                    push(c);
                    break;
                }
            }
            i++;
            c = value.charAt(i);   
        }
    }
    
    /**aggiunge un ElementoPila con 'c' come value */
    public void push(char c){
        ElementoPila nuovo = new ElementoPila(c);
        if(head == null){
            head = nuovo;
        }
        else{
            ElementoPila current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(nuovo);
        }
    }

    /**elimina l'ultimo elemento della pila */
    public void pop(){
        if(head.getNext() == null) head = null;
        else{
            ElementoPila current = head;
            ElementoPila prev = null;
            while(current.getNext() != null){
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            current = null;
        }
    }
    
    /**mostra il contenuto della pila, usato per il debug */
    public void printaPila(){
        ElementoPila current = head;
        while(current.getNext() != null){
            System.out.println(current.getC());
            current = current.getNext();
        }
    }

    /**ritorna l'ultimo elemento, null se la head è null */
    public ElementoPila peek(){
        if(head == null) return null;
        ElementoPila current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current;
    }

    /**controlla se l'espressione è corretta */
    public boolean controllaCorrettezza(){
        if(head == null) return true;
        return false;
    }
}
