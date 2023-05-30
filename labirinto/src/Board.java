import javax.swing.JFrame;
public class Board {
    private static Tela lab = new Tela();
    private static char[][] mat = Main.getMat();
    private static Pallino pal = new Pallino(0, 0, false);
    
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
    public static void primaMossa(){
        int x = pal.getX();
        int y = pal.getY();
    }
    public static Pallino getPal() {
        return pal;
    }
}
