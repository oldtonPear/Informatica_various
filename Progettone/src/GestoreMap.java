import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GestoreMap {
    HashMap<String, ArrayList<File>> map = new HashMap<>();

    public void riempi(){
        GestoreFile ges = new GestoreFile();
        ArrayList<String> listaNomi = ges.getTxt();
        String riga = "";
        for (String s : listaNomi) {
            File f = new File(s);
            try{
                FileReader reader = new FileReader(f);
                BufferedReader br = new BufferedReader(reader);
                riga = br.readLine();
                String[] arrRiga = riga.split(" ");
                while(riga != null){
                    for (int i = 0; i < arrRiga.length; i++) {
                        if(map.get(arrRiga[i]) == null){
                        map.put(arrRiga[i], new ArrayList<>());
                        map.get(arrRiga[i]).add(f);
                        }
                        else map.get(arrRiga[i]).add(f);
                    }
                    riga = br.readLine();
                    if(riga != null) arrRiga = riga.split(" ");
                }
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    public String cercaParola(String parola){
        if(map.get(parola) == null) return "";
        return map.get(parola).toString();
    }
}
