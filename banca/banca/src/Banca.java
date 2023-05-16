import java.util.ArrayList;

public class Banca {
    private static ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    public static void creaCliente(String nome, String cognome, String cod_fiscale){
        listaClienti.add(new Cliente(nome, cognome, cod_fiscale, Cliente.getMovimenti()));
    }

    public static void eliminaCliente(int n){
        printClienti();
        if(n < listaClienti.size()-1) listaClienti.remove(n); 
        else System.out.println("inserisci un numero valido");
    }

    public static void printClienti(){
        int i = 0;
        for (Cliente cliente : listaClienti) {
            System.out.print(i + ": \n");
            System.out.println(cliente.toString());
            i++;
        }
    }

    public static void performaMovimento(Movimento m, Cliente c){
        c.getMovimenti().add(m);
    }
    
    public static void elencaMovimenti(Cliente c){
        int i = 0;
        for (Movimento m : c.getMovimenti()) {
            if(!m.getRimosso()){
                System.out.print(i + ": \n");
                System.out.println(c.getMovimenti().toString());
                i++;
            }
            
        }
    }
    
    public static void eliminaMovimento(int c, int n){
        listaClienti.get(c).getMovimenti().get(n).setRimosso(true);
    }
    public static ArrayList<Cliente> getArrClienti(){
        return listaClienti;
    }
    
    public static String[][] ottieniValoriGrafico(Cliente c){
        
        int annoMinore = c.getMovimenti().get(0).getAnno(), annomaggiore = c.getMovimenti().get(0).getAnno();
        for (int i = 0; i < c.getMovimenti().size(); i++) {
            if(c.getMovimenti().get(i).getAnno() > annomaggiore) annomaggiore = c.getMovimenti().get(i).getAnno();
            if(c.getMovimenti().get(i).getAnno() < annoMinore) annoMinore = c.getMovimenti().get(i).getAnno();
        }

        double importoMaggiore = c.getMovimenti().get(0).getImporto(), importoMinore = c.getMovimenti().get(0).getImporto();
        for (int i = 0; i < c.getMovimenti().size(); i++) {
            if(c.getMovimenti().get(i).getImporto() > importoMaggiore) importoMaggiore = c.getMovimenti().get(i).getImporto();
            if(c.getMovimenti().get(i).getImporto() < importoMinore) importoMinore = c.getMovimenti().get(i).getImporto();
        }
        String[][] mat = new String[(int)(importoMaggiore+importoMinore)/5][annomaggiore];
        int appoggio = 0;
        for (int i = 0; i < importoMaggiore-importoMinore+1; i++) {
            if(i % 5 ==0) System.out.println(importoMaggiore-i);
            appoggio = (int)importoMaggiore-i;
            mat[0][i] = 
            
        }
        System.out.print("    ");
        for (int i = 0; i < annomaggiore-annoMinore+1; i++) {
            System.out.print(annoMinore+i + " | ");
        }
    }
    public static void graficoMovimenti(){

    }
}
