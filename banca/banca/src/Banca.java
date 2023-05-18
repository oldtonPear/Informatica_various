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
        String[][] mat = new String[(int)(Math.abs(importoMaggiore)+Math.abs(importoMinore))/5][annomaggiore];
        for (int i = 0; i < Math.abs(importoMaggiore-importoMinore+1); i++) {
            if(i % 5 ==0){
                mat[0][i] = importoMinore + 5*i + "";
            }
        }
        for (int i = 0; i < Math.abs(annomaggiore-annoMinore+1); i++) {
            mat[i][mat.length] = annoMinore+i + "";
        }
        return mat;
    }
    public static void graficoMovimenti(Cliente c){
        String[][] mat = ottieniValoriGrafico(c);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(esisteCorrispondenza(Double.valueOf(mat[mat[mat.length-1].length-1][i]), Double.valueOf(mat[i][0]), c)){
                    mat[i][j] = "X";
                }
            }
        }
        stampaMatrice(mat);
    }
    public static void stampaMatrice(String[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.println(mat[i][j]);
            }
        }
    }
    public static boolean esisteCorrispondenza(double anno, double soldi, Cliente c){
        for (int i = 0; i< c.getMovimenti().size(); i++) {
            if(c.getMovimenti().get(i).getAnno() == anno && c.getMovimenti().get(i).getImporto() == soldi) return true; 
        }
        return false;
    }
}
