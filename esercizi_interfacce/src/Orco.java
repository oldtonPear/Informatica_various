public class Orco implements Dasher, Spellcaster, Shooter{
    int forza = 15;
    String type;
    Orco(int difesa, String type){
        this.forza = difesa;
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
