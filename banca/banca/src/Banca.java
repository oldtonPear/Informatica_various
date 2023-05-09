import java.util.ArrayList;
import java.util.Scanner;

public class Banca {
    private static ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();

    public static void creaCliente(){
        Scanner scn = new Scanner(System.in);
        System.out.println("inserisci il nome:");
        String nome = scn.nextLine();
        System.out.println("inserisci il cognome:");
        String cognome = scn.nextLine();
        System.out.println("inserisci il codice fiscale:");
        String cod_fiscale = scn.nextLine();
        listaClienti.add(new Cliente(nome, cognome, cod_fiscale, Cliente.getMovimenti()));
        scn.close();
    }
    public void eliminaCliente(Cliente c){
        if(listaClienti.contains(c)) listaClienti.remove(c);
    }

    public void performaMovimento(Movimento m, Cliente c){
        c.getMovimenti().add(m);
    }
    public static void displayClienti(){
        for (Cliente cliente : listaClienti) {
            System.out.println(cliente.getNome() + cliente.getCognome());
        }
    }
}
