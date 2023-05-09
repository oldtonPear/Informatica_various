import java.util.Scanner;

public class Main {


    public static int scegli(){
        Scanner scn = new Scanner(System.in);
        
        try{
            System.out.println("1: inserisci un cliente");
            System.out.println("2: elimina un cliente:");
            System.out.println("3: fai un movimento");
            System.out.println("4: visualizza lista dei movimenti");
            System.out.println("7: esci");
            System.out.print("inserisci la scelta: ");
            int scelta = scn.nextInt();
            scn = new Scanner(System.in);
            System.out.println(scelta);
            if(scelta < 8 && scelta > 0){
                return scelta;
            }
            scegli();
        }
        catch(Exception e){
            System.out.println("inserisci un valore valido");
            return scegli();
        }
        finally{
            scn.close();
        }
        return 0;
    }
        public static void menu(){
            int scelta = scegli();
                switch(scelta){
                    case 1:
                        Banca.creaCliente();
                        menu();
            }
            
    }
    public static void main(String[] args) {
        menu();
    }
}
