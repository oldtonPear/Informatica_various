public class Main {
    public static void main(String[] args)  {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", true, 1);
        g.collega("Mestre", "Milano", true, 2);
        g.collega("Mestre", "Catanzaro", true, 5);
        g.collega("Catanzaro", "Messina", true, 1);
        //g.collega("Palermo", null, true);
        System.out.println(g.toString());
        System.out.println(g.isConnected());
        /*g.Dijkstra(g.maxOrder());
        g.printDist();
        System.out.println("");
        g.printPrev();*/
    }
}
