public class Main {
    public static void main(String[] args) {
        GestoreListe <String> ges = new GestoreListe();
        ges.nuovoNodo("gigi", 0);
        ges.printaLista(ges.getHead());
        
        ges.nuovoNodo("pino", 1);
        ges.printaLista(ges.getHead());
        
        ges.nuovoNodo("gianni", 2);
        ges.printaLista(ges.getHead());
        
        ges.nuovoNodo("pinotto", 2);
        
        //ges.rimuoviNodo(1);
        //ges.rimuoviPerValore(ges.getHead(), "christian");
        ges.printaLista(ges.getHead());
        
        System.out.println(ges.cercaElemento("pino"));
        ges.controllaAvanti();
        System.out.println("");
        ges.controllaIndietro();
        
        
    }
}