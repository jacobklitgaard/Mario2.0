public class Kunde {
    private int id;
    private String navn;
    private String afhentning;

    public Kunde(int id, String navn, String afhentning){
        this.id = id;
        this.navn = navn;
        this.afhentning = afhentning;
    }

    public int getId(){
        return id;
    }
    public String getNavn(){
        return navn;
    }
    public String getAfhentning(){
        return afhentning;
    }
    @Override
    public String toString() {
        return "\nNavn: " + getNavn() +
               "\nTelefon: " + getId() +
               "\nAfhentning: " + getAfhentning();
    }
}
