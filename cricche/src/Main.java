public class Main {
    public static void main(String[] args) {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", true);
        g.collega("Mestre", "Milano", true);
        g.collega("Catanzaro", "Messina", true);
        System.out.println(g.isConnected());
    }
}
