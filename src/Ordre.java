import java.util.ArrayList;

public class Ordre {
    private ArrayList<Pizza> pizzaliste; // Her kalder vi på menuen
    private Kunde kunde; // henter kundeobjekter fra Kunde
    private int totalPris;


    public Ordre(ArrayList<Pizza> pizzaliste, Kunde kunde, int totalPris) {
        this.kunde = kunde;
        this.pizzaliste = pizzaliste;
        this.totalPris = totalPris;
    }

    public Kunde getKunde() {
        return kunde;
    }

    @Override
    public String toString() {
        String pizzaString = "";
        for (int i = 0; i < pizzaliste.size(); i++) {
            pizzaString += pizzaliste.get(i).toString() + "\n";
        }
        return  pizzaString +
                "\n\u001B[3mKundeoplysninger\u001B[0m:\nNavn: " +
                kunde.getNavn() +
                "\nTelefon: " + kunde.getTlf() +
                "\nAfhentning: " + kunde.getAfhentning() +
                "\nTotal pris: " + totalPris + "kr\n";
    }
}