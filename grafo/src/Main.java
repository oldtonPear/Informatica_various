public class Main {
    public static void main(String[] args){
        Grafo<String> g = new Grafo<>();
        g.collega("buonasera", "buongiorno", true);
        //System.out.println(g.toString());
        g.collega("ciao", "salve", true);
        g.collega("buongiorno", "salve", true);
        g.collega("buonasera", "salve", false);
        System.out.println(g.toString());
        System.out.println(g.numeroVertici());
        System.out.println(g.numeroArchi());
        System.out.println(g.isFullyConnected());
        System.out.println(g.maxOrder());
        System.out.println(g.minOrder());
    }
}
