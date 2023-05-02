import java.util.Scanner;
public class Main {

    public static double calcola(int n1, int n2, char operazione) throws Exception{
        switch(operazione){
            case '+':
                return (double)n1 + n2;
            case '-':
                return (double)n1 - n2;
            case '*':
                return (double)n1*n2;
            case '/':
                if(n2 == 0) throw new IllegalArgumentException();
                return (double)n1/n2;
        }
        return 0;
    }

    public static int getInt(){
        Scanner scn = new Scanner(System.in);
        int n = 0;
        try{
            System.out.print("inserisci un intero: ");
            n = scn.nextInt();
        }
        catch(Exception e){
            System.out.println("inserisci un numero valido");
            getInt();
        }
        return n;
         
    }
    public static char getChar(){
        Scanner scn = new Scanner(System.in);
        char c = '\n';
            System.out.print("inserisci un carattere: ");
            c = scn.nextLine().charAt(0);
            if(c != '+' && c != '-')
                if(c != '*' && c != '/'){
                    System.out.println("inserisci '+' oppure '-' oppure '*' oppure '/'");
                    getChar();
                }
        return c;
    }

    public static void init(){
        double result = 0d;
        try{
            result = calcola(getInt(), getInt(), getChar());
        }
        catch(Exception e){
            System.out.println("operazione non valida, riavvio il programma");
            init();
        }
        System.out.println(result);
    }
    
    public static void main(String[] args){
        init();
    }
}
