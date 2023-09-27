public class Main {
    public static void main(String[] args) {
        String espressione = "4 ()* 5 +)2+2*2]+1";
        Pila p = new Pila(espressione);
        System.out.println(p.controllaCorrettezza());
    }
}
