import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GestoreMap {
    static HashMap<String, ArrayList<File>> map = new HashMap<>();

    public void riempi(){
        GestoreFile gesFile = Utility.getGesFile();
        ArrayList<String> listaNomi = gesFile.ottieniNomiFile();
        String riga = "";
        for (String s : listaNomi) {
            File f = new File(s);
            try{
                gesFile.setfReader(new FileReader(f));
                gesFile.setbReader(new BufferedReader(gesFile.getfReader()));
                riga = gesFile.getbReader().readLine();
                String[] arrRiga = riga.split(" ");
                while(riga != null){
                    for (int i = 0; i < arrRiga.length; i++) {
                        if(map.get(arrRiga[i]) == null){
                            map.put(arrRiga[i], new ArrayList<File>());
                            map.get(arrRiga[i]).add(f);
                        }
                        else if(!(checkData(map.get(arrRiga[i]), f))){
                            map.get(arrRiga[i]).add(f);
                        } 
                    }
                    riga = gesFile.getbReader().readLine();
                    if(riga != null) arrRiga = riga.split(" ");
                }
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
    public boolean checkData(ArrayList<File> arrList, File f){
        for (File file : arrList) {
            if(file == f) return true;
        }
        return false;
    }
}
