import java.io.*;
import java.security.SecureRandom;
public class GestoreFile {
    

    public void creaFile(){
        FileWriter w;
        BufferedWriter writer = null;
        try{
            for (int i = 0; i <= 10; i++) {
                w = new FileWriter(new File("src/..", "file" + i + ".txt"));
                writer = new BufferedWriter(w);
                String lower = "abcdefghijklmnopqrstuvwxyz";
                String upper = lower.toUpperCase();
                String numeri = "0123456789";
                String perRandom = upper + lower + numeri;
                int lunghezzaRandom = 20;

                SecureRandom sr = new SecureRandom();
                StringBuilder sb = new StringBuilder(lunghezzaRandom);
                for (int j = 0; j < lunghezzaRandom; j++) {
                    int randomInt = sr.nextInt(perRandom.length());
                    char randomChar = perRandom.charAt(randomInt);
                    sb.append(randomChar);
                }

                writer.write(sb.toString());
                writer.flush();
            }
            writer.close();
        } catch(Exception e){
            System.out.println(e.getCause());
        }
        
    }
}
