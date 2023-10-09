import java.io.*;
import java.util.Scanner;
public class Main {
    static GestoreFile gesFile = new GestoreFile();
    static GestoreCoda gesCoda = new GestoreCoda();
    static GestoreMap gesMap = new GestoreMap();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        gesFile.creaFile(8);
        gesCoda.creaCoda();
        gesCoda.printaCoda();
        creaFileStampa();
        gesMap.riempi();
        System.out.println("\nche parola vuoi cercare?");
        creaFilteredPrintQueue(scn.nextLine());
    }

    /***scrive il contenuto dei file di testo in un file "Print.txt" */
    public static void creaFileStampa(){
        String s, result = "";
        FileReader r;
        BufferedReader reader;
        while(gesCoda.getHead() != null){
            try{
                r = new FileReader(gesCoda.getHead().getData());
                reader = new BufferedReader(r);
                result +="*****INIZIO*****" + "\n";
                s = reader.readLine();
			    while(s!=null){
                    result += s + "\n";
				    s=reader.readLine();
			    }
            result +="***** FINE *****" + "\n";
            }catch(Exception e){
                System.out.println(e.getCause());
            }
            scriviSuOutput(result);
            gesCoda.rimozione();
        }
    }
    /***scrive la stringa passata su "Print.txt" */
    public static void scriviSuOutput(String s){
        BufferedWriter writer;
        try{
            FileWriter w = new FileWriter("Print.txt");
            writer = new BufferedWriter(w);
            writer.write(s);
            writer.flush();
            writer.close();
        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }

    public static void creaFilteredPrintQueue(String s){
        String parole = gesMap.cercaParola(s);
        BufferedWriter writer;
        try{
            FileWriter w = new FileWriter("FilteredPrintQueue.txt");
            writer = new BufferedWriter(w);
            writer.write(parole);
            writer.flush();
            writer.close();
        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }
}
