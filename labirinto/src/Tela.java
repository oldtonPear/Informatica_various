import javax.swing.*;
import java.awt.*;
public class Tela extends JPanel{
    public void paintComponent(Graphics g){ //disegna il menu
        super.paintComponent(g);
        this.setBackground(Color.white);
        //g.drawOval(250, 250, 100, 100);
        paintMat(g);
        
    }
    public static void paintMat(Graphics g){
        char[][] mat = Main.getMat();
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat.length; j++) {
                g.setColor(Color.gray);
                if(mat[i][j] == 'X'){
                    g.fillRect(j*100, i*100, 100, 100);
                }
                else if(mat[i][j] == 'U'){
                    g.setColor(Color.green);
                    g.fillRect(j*100, i*100, 100, 100);
                    Board.getPal().setX(j);
                }
                else if(mat[i][j] == 'E'){
                    g.setColor(Color.red);
                    g.fillRect(j*100, i*100, 100, 100);
                }
            }
            disegnaPal(g, Board.getPal());
    }
    }
    public static void disegnaPal(Graphics g, Pallino pal){
        char[][] mat = Main.getMat();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(Board.getPal().getX() == j && Board.getPal().getY() == i){
                    g.setColor(Color.black);
                    g.fillOval(j*100, i*100, 100, 100);
                }
            }
            
        }
    }
}
