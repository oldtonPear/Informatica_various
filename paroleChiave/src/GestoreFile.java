import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GestoreFile {
    private FileReader fReader;
    private BufferedReader bReader;

    public BufferedReader getbReader() {
        return bReader;
    }
    public FileReader getfReader() {
        return fReader;
    }
    public void setfReader(FileReader fReader) {
        this.fReader = fReader;
    }
    public void setbReader(BufferedReader bReader) {
        this.bReader = bReader;
    }
    
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

    
}
