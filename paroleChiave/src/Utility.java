import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Utility {
    private static GestoreFile gesFile = new GestoreFile();
    private static GestoreMap gesMap = new GestoreMap();

    public static GestoreFile getGesFile() {
        return gesFile;
    }
    public static GestoreMap getGesMap() {
        return gesMap;
    }

    public static void init(){
        gesMap.riempi();
    }
    public static double calcoloTF(File file, String parola){
        double numeroDiTermini = 0, numeroOccorrenze = 0;
        try{
            gesFile.setfReader(new FileReader(file));
            gesFile.setbReader(new BufferedReader(gesFile.getfReader()));
            String riga = gesFile.getbReader().readLine();
                String[] arrRiga = riga.split(" ");
                while(riga != null){
                    for (int i = 0; i < arrRiga.length; i++) {
                        numeroDiTermini++;
                        if(parola.compareTo(arrRiga[i])==0) numeroOccorrenze++;
                    }
                    riga = gesFile.getbReader().readLine();
                    if(riga != null) arrRiga = riga.split(" ");
                }

        }catch(Exception e){
            System.out.println("Inserisci il nome di un file adeguato!!\n\n\n");
            Main.menu();
        }

        return numeroOccorrenze / Math.abs(numeroDiTermini);
    }

    public static double calcoloIDF(String parola){
        double numeroDocumenti = gesFile.ottieniNumeroFile(), numeroDocumentiConI = 1;
        try{
            numeroDocumentiConI = gesMap.map.get(parola).size();
        }catch(NullPointerException e){
            System.out.println("PAROLA NON TROVATA\n\n\n");
            Main.menu();
        }
        

        return  Math.log10(Math.abs(numeroDocumenti) / Math.abs(numeroDocumentiConI));
    }
    public static double calcoloTF_IDF(String parola, File file){
        return calcoloTF(file, parola) * calcoloIDF(parola);
    }
}