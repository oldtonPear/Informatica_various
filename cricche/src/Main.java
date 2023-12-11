public class Main {
    public static void main(String[] args) {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", true);
        g.collega("Mestre", "Milano", true);
        g.collega("Mestre", "Catanzaro", true);
        g.collega("Catanzaro", "Messina", true);
        g.collega("Palermo", null, true);
        System.out.println(g.toString());
        System.out.println(g.isConnected());
        g.Dijkstra(g.maxOrder());
        g.printDist();
        System.out.println("");
        g.printPrev();
    }
}