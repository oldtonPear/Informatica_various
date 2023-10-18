import java.io.File;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Utility.init();
        menu();
        
    }

    public static void menu(){
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Benvenuto al softwere per il calcolo del: TF_IDF di una parola rispetto ad una collezione di testi!");
        System.out.println("Desideri calcolare il TF-IDF di una sola parola (inserisci 1) oppure di tutte le parole (inserisci 2)?");
        switch(scn.nextInt()){
            case 1 -> {
                scn = new Scanner(System.in);
                System.out.print("Inserisci la parola: ");
                String parola = scn.nextLine();
                System.out.print("Ora inserisci il nome del file: ");
                File f = new File(scn.nextLine());
                System.out.println(Utility.calcoloTF_IDF(parola, f));
            }
            case 2 -> {
                Utility.printaImportanza();
            }
        } 
    }
}