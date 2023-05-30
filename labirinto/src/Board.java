import javax.swing.JFrame;
public class Board {
    private static Tela lab = new Tela();
    private static char[][] mat = Main.getMat();
    private static Pallino pal = new Pallino(0, 0, false, 0);
    
    public static void init(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1080);
        frame.setBounds(0, 0, 1000, 1080);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(lab);
    }
    public static void faiTurno(){

    }
    public static int[] primaMossa(){
        int[] mosse = new int[2];
        int x = pal.getX();
        int y = pal.getY();
        switch(pal.getDirezione()){
            //rivolto verso il basso
            case 0 -> {
                if(mat[x][y+1] == ' '){
                    y += 1;
                    break;
                }

            }
            //rivolto verso sinistra
            case 1 -> {

            }
            //rivolto verso su
            case 2 -> {

            }
            //rivolto verso destra
            case 3 -> {

            }
        }
        return mosse;
    }
    public static Pallino getPal() {
        return pal;
    }
}
