import java.util.Scanner;

public class Main {
    
    
    public static int scegli(){
        Scanner scn = new Scanner(System.in);
        boolean uscito = false;
        try{
            System.out.println("1: inserisci un cliente/elimina un cliente");
            System.out.println("2: mostra i clienti presenti");
            System.out.println("3: fai un movimento/elimina un movimento");
            System.out.println("4: visualizza lista dei movimenti");
            System.out.println("5: calcola il bilancio");
            System.out.println("6: visualizza grafico");
            System.out.println("7: esci");
            System.out.print("inserisci la scelta: ");
            int scelta = scn.nextInt();
            scn = new Scanner(System.in);
            if(scelta < 8 && scelta > 0){
                switch(scelta){
                    case 1 -> {
                        System.out.println("1: aggiungi un cliente");
                        System.out.println("2: elimina un cliente");
                        int secondascelta = scn.nextInt();
                        scn = new Scanner(System.in);
                        switch(secondascelta){
                            case 1 -> {
                                System.out.println("inserisci il nome:");
                                String nome = scn.nextLine();
                                System.out.println("inserisci il cognome:");
                                String cognome = scn.nextLine();
                                System.out.println("inserisci il codice fiscale:");
                                String cod_fiscale = scn.nextLine();
                                Banca.creaCliente(nome, cognome, cod_fiscale);
                            }
                            case 2 -> {
                                int n = scn.nextInt();
                                Banca.eliminaCliente(n);
                            }
                        }
                    }
                    case 2 -> {
                        Banca.printClienti();
                    }
                    case 3 -> {
                        System.out.println("1: fai un movimento");
                        System.out.println("2: elimina un movimento");
                        int secondascelta = scn.nextInt();
                        scn = new Scanner(System.in);
                        switch(secondascelta){
                            case 1 -> {
                                System.out.println("inserisci anno:");
                                int anno = scn.nextInt();
                                System.out.println("inserisci importo");
                                double importo = scn.nextDouble();
                                boolean entrata = false;
                                if(importo > 0) entrata = true;
                                Banca.printClienti();
                                System.out.println("inserisci il numero del cliente che ricevera la pecunia");
                                int indice1 = scn.nextInt();
                                System.out.println("inserisci il numero del cliente che sborsera i denari");
                                int indice2 = scn.nextInt();
                                if(indice1 == indice2){
                                    System.out.println("inserisci due clienti diversi");
                                    break;
                                }
                                Banca.performaMovimento(new Movimento(anno, entrata, importo, Banca.getArrClienti().get(indice2), false), Banca.getArrClienti().get(indice1));
                            }
                            case 2 -> {
                                Banca.printClienti();
                                System.out.println("indica il cliente di cui vuoi eliminare il movimento:");
                                int cliente = scn.nextInt();
                                Banca.elencaMovimenti(Banca.getArrClienti().get(cliente));
                                System.out.println("indica il movimento da eliminare:");
                                int movimento = scn.nextInt();
                                Banca.eliminaMovimento(cliente, movimento);
                            }
                        }
                    }
                    case 4 -> {
                        Banca.printClienti();
                        System.out.println("indica il cliente di cui vuoi sapere i movimenti");
                        int n = scn.nextInt();
                        Banca.elencaMovimenti(Banca.getArrClienti().get(n));
                    }
                    case 5 -> {
                        Banca.printClienti();
                        System.out.println("indica di quale cliente calcolare il bilacio:");
                        int n = scn.nextInt();
                        System.out.println(Banca.getArrClienti().get(n).bilancio());
                    }
                    case 6 -> {
                        Banca.printClienti();
                        System.out.println("indica il cliente di cui vuoi vedere il grafico");
                        int n = scn.nextInt();
                        Banca.graficoMovimenti(Banca.getArrClienti().get(n));
                    }
                    case 7 -> uscito = true;
                }
            }
            if(!uscito){
                scegli();
            } 
        }
        catch(Exception e){
            System.out.println("inserisci un valore valido \n");
            e.printStackTrace();
            scegli();
        }
        finally{
            scn.close();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        scegli();
    }
}
