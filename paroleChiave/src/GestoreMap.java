import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GestoreMap {
    static HashMap<String, ArrayList<File>> map = new HashMap<>();
    static HashMap<String, Double> mapImportanza = new HashMap<>();
    static ArrayList<String> arrKeySet = new ArrayList<>();

    public void riempi(){
        
        GestoreFile gesFile = Utility.getGesFile();
        ArrayList<String> listaNomi = gesFile.ottieniNomiFile();
        String riga = "";
        System.out.println("Caricamento risorse, attendi prego");
        for (String s : listaNomi) {
            File f = new File(s);
            try{
                gesFile.setfReader(new FileReader(f));
                gesFile.setbReader(new BufferedReader(gesFile.getfReader()));
                riga = gesFile.getbReader().readLine();
                riga = riga.replaceAll("[^a-zA-Z0-9]", " ");
                String[] arrRiga = riga.split(" ");
                while(riga != null){
                    for (int i = 0; i < arrRiga.length; i++) {
                        if(!map.containsKey(arrRiga[i])){
                            map.put(arrRiga[i], new ArrayList<File>());
                            map.get(arrRiga[i]).add(f);
                        }
                    }
                    riga = gesFile.getbReader().readLine();
                    if(riga != null){
                        riga = riga.replaceAll("[^a-zA-Z0-9]", " ");
                        arrRiga = riga.split(" ");
                    } 
                }
                
                
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        for (String s : map.keySet()) {
            arrKeySet.add(s);
        }
    }

    public void riempiMapImportanza(){
        double tfidf = 0;
        double progress = 0, i = 0;
        long size = arrKeySet.size();
        for (String s : arrKeySet) {
            i++;
            progress = i/size*100;
            System.out.println(String.format("%.2f", progress) + "%");
            for (File f : map.get(s)) {
                tfidf += Utility.calcoloTF_IDF(s, f);
                
            }
            mapImportanza.put(s, tfidf);
            tfidf = 0;
        }
    }
    public void printaTfidf(){
        for (String s : arrKeySet) {
            System.out.println(s +" "+ mapImportanza.get(s));
        }
    }
}