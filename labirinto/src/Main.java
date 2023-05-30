import java.io.BufferedReader;
import java.io.FileReader;
public class Main {
    private static char[][] mat = new char[10][10];
    public static void main(String[] args) {
        mat = initMat();
        Board.init();
    }

    private static char[][] initMat(){
        try{
            FileReader r = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(r);
            String s = reader.readLine();
            int i = 0;
            while(s != null){
                for (int j = 0; j < s.length(); j++) {
                    mat[i][j] = s.charAt(j);
                }
                s = reader.readLine();
                i++;
            }
            for (int j = 0; j < mat.length; j++) {
                System.out.println();
                for (int j2 = 0; j2 < mat.length; j2++) {
                    System.out.print(mat[j][j2]);
                }
            }
        }catch(Exception e){
            System.out.println("errore");
        } 
        return mat;
    }
    public static char[][] getMat(){
        return mat;
    }
}
