public class Main {
    public static void main(String[] args) {
        GestoreListe <String> ges = new GestoreListe();
        ges.nuovoNodo("ciao", 0);
        ges.printaLista(ges.getHead());

        ges.nuovoNodo("sono", 1);
        ges.printaLista(ges.getHead());

        ges.nuovoNodo("christian", 2);
        ges.printaLista(ges.getHead());

        //ges.rimuoviNodo(0);
        ges.rimuoviPerValore(ges.getHead(), "ciao");
        ges.printaLista(ges.getHead());

        System.out.println(ges.cercaElemento("sono"));
    }
}