import java.time.LocalTime;

public class Kunde {
    private int tlf;
    private String navn;
    private LocalTime afhentning; //LocalTime til at hente klokkeslæt som variable

    public Kunde(int tlf, String navn, LocalTime afhentning){
        this.tlf = tlf;
        this.navn = navn;
        this.afhentning = afhentning;
    }
// Her laver vi getter, for at kunne hente oplysningerne fra denne klasse over i en anden class.
    public int getTlf(){
        return tlf;
    }
    public String getNavn(){
        return navn;
    }
    public LocalTime getAfhentning() {
        return afhentning;
    }
    @Override
    public String toString() {
        return "Navn: " + getNavn() +
               "\nTelefon: " + getTlf() +
               "\nAfhentning: " + getAfhentning();
    }
}
