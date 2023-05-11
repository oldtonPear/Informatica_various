import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.print(i + ": \n");
            System.out.println(c.getMovimenti().toString());
            i++;
        }
        
    }
    
    public static void eliminaMovimento(int c, int n){
        listaClienti.get(c).getMovimenti().remove(n);
    }
    public static ArrayList<Cliente> getArrClienti(){
        return listaClienti;
    }
    
}
