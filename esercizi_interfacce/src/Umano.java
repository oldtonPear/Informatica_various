public class Umano implements Dasher, Shooter, Spellcaster{
    int difesa = 15;
    String type;
    Umano(int difesa, String type){
        this.difesa = difesa;
        this.type = type;
    }
    @Override
    public int shoot() {
        if(this.type == "shooter") return 5;
        return 0;
    }
    @Override
    public int cast() {
        if(this.type == "spellcaster") return 5;
        return 0;
    }
    @Override
    public int charge() {
        if(this.type == "dasher") return 5;
        return 0;
    }
}
