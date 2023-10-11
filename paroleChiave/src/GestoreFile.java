import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GestoreFile {
    FileReader fReader;
    BufferedReader bReader;
    
    /**ritorna un arrayList contenente stringhe con i nomi di tutti i file .txt */
    public ArrayList<String> ottieniNomiFile(){
        File file = new File("src/..");
		String[] sFile = file.list();
        ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < sFile.length; i++) {
            if(sFile[i].contains(".txt")){
                result.add(sFile[i]);
            }
        }
        return result;
    }

    public int ottieniNumeroFile(){
        int result = 0;
        File file = new File("src/..");
		String[] sFile = file.list();
		for (int i = 0; i < sFile.length; i++) {
            if(sFile[i].contains(".txt")){
                result++;
            }
        }
        return result;
    }

    public double calcoloTF(File file, String parola){
        int numeroDiTermini = 0, numeroOccorrenze = 0;
        try{
            fReader = new FileReader(file);
            bReader = new BufferedReader(bReader);


        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        return numeroOccorrenze / Math.abs(numeroDiTermini);
    }

    public double calcoloIDF(String parola){{
        GestoreMap gesMap = new GestoreMap();
        int numeroDocumenti = ottieniNumeroFile(), numeroDocumentiConI = gesMap.map.get(parola).size();



        return  Math.log10(Math.abs(numeroDocumenti) / Math.abs(numeroDocumentiConI));
    }

    }
}
