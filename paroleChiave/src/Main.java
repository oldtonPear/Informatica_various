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
        System.out.print("Inserisci la parola: ");
        String parola = scn.nextLine();
        System.out.print("Ora inserisci il nome del file: ");
        File f = new File(scn.nextLine());
        System.out.println(Utility.calcoloTF_IDF(parola, f));
    }
}