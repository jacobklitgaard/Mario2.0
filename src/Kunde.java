public class Kunde {
    private int tlf;
    private String navn;
    private String afhentning;

    public Kunde(int tlf, String navn, String afhentning){
        this.tlf = tlf;
        this.navn = navn;
        this.afhentning = afhentning;
    }
    public int getTlf(){
        return tlf;
    }
    public String navn(){
        return navn;
    }
    public String getAfhentning(){
        return afhentning;
    }
}
