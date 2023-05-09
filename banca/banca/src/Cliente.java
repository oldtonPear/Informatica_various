import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nome, cognome, cod_fiscale;
    private int bilancio;
    private static ArrayList<Movimento> movimenti = new ArrayList<Movimento>();
    Cliente(String nome, String cognome, String cod_fiscale, ArrayList<Movimento> movimenti){
        this.nome = nome;
        this.cognome = cognome;
        this.cod_fiscale = cod_fiscale;
        this.bilancio = bilancio;
    }
    public void azione(Cliente c1, Movimento m, Cliente c2){
        Scanner scn = new Scanner(System.in);
        m = new Movimento(scn.nextInt(), scn.nextBoolean(), scn.nextDouble(), c2);
    }
    public static ArrayList<Movimento> getMovimenti(){
        return movimenti;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
}
