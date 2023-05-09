import java.util.ArrayList;

public class Movimento {
    private int anno;
    private boolean entrata;
    private double trasferimento;
    private Cliente cliente2 = new Cliente(null, null, null, null); 
    Movimento(int anno, boolean entrata, double trasferimento, Cliente cliente2){
        this.anno = anno;
        this.entrata = entrata;
        this.trasferimento = trasferimento;
        this.cliente2 = cliente2;
    }
    
}
