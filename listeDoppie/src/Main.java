public class Main {
    public static void main(String[] args) {
        GestoreListe <Integer> ges = new GestoreListe();
        ges.nuovoNodo(19, 0);
        ges.printaLista(ges.getHead());

        ges.nuovoNodo(20, 1);
        ges.printaLista(ges.getHead());

        ges.nuovoNodo(10, 2);
        ges.printaLista(ges.getHead());
        ges.nuovoNodo(30, 2);

        //ges.rimuoviNodo(1);
        //ges.rimuoviPerValore(ges.getHead(), "christian");
        //ges.printaLista(ges.getHead());

        System.out.println(ges.cercaElemento(10));
        //ges.controllaAvanti();
        System.out.println("");
        //ges.controllaIndietro();


    }
}