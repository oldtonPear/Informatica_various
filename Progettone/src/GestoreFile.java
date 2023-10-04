import java.io.*;
import java.util.Random;
import java.util.ArrayList;
public class GestoreFile {
    FileReader r;
    FileWriter w;

    public void creaFile(){
        Random random = new Random();
        FileWriter w;
        BufferedWriter writer = null;
        int numeroFile = 8;
        int numeroRighe;
        try{
            for (int i = 0; i <= numeroFile; i++) {
                w = new FileWriter(new File("src/..", "file" + i + ".txt"));
                writer = new BufferedWriter(w);
                numeroRighe = 3 + random.nextInt(8);
                for (int j = 0; j < numeroRighe; j++) {
                    writer.write("riga" + j);
                    writer.newLine();
                    writer.flush();
                }
            }
            writer.close();
        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }
    public ArrayList getTxt(){
        File file = new File("src/..");
		String[] sFile = file.list();
        ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < sFile.length; i++) {
            if(sFile[i].contains("file") && sFile[i].contains(".txt")){
                result.add(sFile[i]);
            }
        }
        return result;
    }
    public void scriviSuOutput(String s){
        BufferedWriter writer;
        try{
            w = new FileWriter("Print.txt");
            writer = new BufferedWriter(w);
            writer.write(s);
            writer.flush();
            writer.close();
        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }
}
