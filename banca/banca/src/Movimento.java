import java.util.ArrayList;

public class Movimento {
    private int anno;
    private boolean rimosso;
    private boolean entrata;
    private double importo;
    private Cliente cliente2 = new Cliente(null, null, null, null); 
    Movimento(int anno, boolean entrata, double importo, Cliente cliente2, boolean rimosso){
        this.anno = anno;
        this.entrata = entrata;
        this.importo = importo;
        this.cliente2 = cliente2;
        this.rimosso = rimosso;
    }
    public String toString(){
        return anno + "\n" + importo + "\n" + cliente2.toString();
    }
    public double getImporto(){
        return importo;
    }
    public void setRimosso(boolean rimosso){
        this.rimosso = rimosso;
    }
    public boolean getRimosso(){
        return rimosso;
    }
    public int getAnno(){
        return anno;
    }
}
