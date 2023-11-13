public class Main {
    public static void main(String[] args) {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", false);
        g.collega("Mestre", "Milano", false);
        g.collega("Mestre", "Catanzaro", false);
        g.collega("Catanzaro", "Messina", false);
        System.out.println(g.toString());
        System.out.println(g.isConnected());
        g.Dijkstra(g.maxOrder());
        g.printDist();
        System.out.println("");
        g.printPrev();
    }
}