import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        Utility.init();
        System.out.println(Utility.calcoloTF_IDF("il", new File("file1.txt")));
    }
}