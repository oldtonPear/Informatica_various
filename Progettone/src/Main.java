import java.util.ArrayList;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        GestoreFile gesFile = new GestoreFile();
        GestoreCoda gesCoda = new GestoreCoda();
        gesFile.creaFile();
        gesCoda.creaCoda();
        gesCoda.printaCoda();
        gesCoda.creaFileStampa();
    }
}
