import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nome, cognome, cod_fiscale;
    private static ArrayList<Movimento> movimenti = new ArrayList<Movimento>();
    Cliente(String nome, String cognome, String cod_fiscale, ArrayList<Movimento> movimenti){
        this.nome = nome;
        this.cognome = cognome;
        this.cod_fiscale = cod_fiscale;
    }
    public String getMovimentiToSTring(){
        return movimenti.toString();
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
    public String toString(){
        return this.nome + "\n" + this.cognome + "\n" + this.cod_fiscale + "\n";
    }
    public double bilancio(){
        double dindini = 0;
        for (Movimento movimento : movimenti) {
            dindini += movimento.getImporto();
        }
        return dindini;
    }
}
