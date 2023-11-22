import java.io.BufferedWriter;
import java.io.FileWriter;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args)  {
        Grafo<String> g = new Grafo<>();
        g.collega("Torino", "Milano", true, 1);
        g.collega("Mestre", "Milano", true, 2);
        g.collega("Mestre", "Catanzaro", true, 5);
        g.collega("Catanzaro", "Messina", true, 1);
        g.collega("Mestre", "Oriago", true, 7);
        //g.collega("Palermo", null, true);
        System.out.println(g.toString());
        System.out.println(g.isConnected());
        g.Dijkstra(g.firstVertex());
        g.printDist();
        g.printPrev();
        GestoreJson<String> gesJson = new GestoreJson<>(g.getNodi(), g.getArchi());
        Gson gson = new Gson();
        String s = gson.toJson(gesJson).replaceAll("},", "},\n").replaceAll("],", "],\n").replaceAll("\\[", "[\n");
        System.out.println(s);
        creaJson(s);
    }
    @SuppressWarnings("unchecked")
    public static void creaJson(String s){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("graph.json"));
            writer.write(s);
            writer.flush();
            writer.close();
        }catch(Exception T){
            T.printStackTrace();
        }
    }
}
