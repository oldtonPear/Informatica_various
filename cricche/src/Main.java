public class Main {
    public static void main(String[] args) {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", true);
        g.collega("Mestre", "Milano", true);
        g.collega("Catanzaro", "Messina", true);
        System.out.println(g.toString());
        System.out.println(g.isConnected());
        g.Dijkstra(g.maxOrder());
        System.out.println(g.getDist().values());
        System.out.println(g.getPrev().values());
    }
}
