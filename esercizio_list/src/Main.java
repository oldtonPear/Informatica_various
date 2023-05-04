import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		FileReader input;
		FileWriter output;
		String s;
        ArrayList<String> parole = new ArrayList<String>();
		try{
			input = new FileReader("input.txt");
			output = new FileWriter("output.txt");
			BufferedReader in = new BufferedReader(input);
			BufferedWriter out = new BufferedWriter(output);
			s = in.readLine();
			while(s!=null){
				parole.add(s);
				s=in.readLine();
			}
			Collections.sort(parole);
            for (String string : parole) {
                System.out.println(string);
                output.write(string + "\n");
                output.flush();
            }
           
			input.close();
			output.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
