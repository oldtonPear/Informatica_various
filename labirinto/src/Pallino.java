public class Pallino {
    private int x, y, direzione;
    private boolean arrivato;
    
    Pallino(int x, int y, boolean arrivato, int direzione){

    }

    public void muoviSu(){
        y -= 1;
    }
    public void muoviGiu(){
        y += 1;
    }
    public void muoviDx(){
        x += 1;
    }
    public void muoviSx(){
        x -= 1;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setArrivato(boolean arrivato) {
        this.arrivato = arrivato;
    }
    public int getDirezione() {
        return direzione;
    }
    public void setDirezione(int direzione) {
        this.direzione = direzione;
    }
}
