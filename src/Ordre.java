import java.util.ArrayList;

public class Ordre {
    private Kunde kunde;
    private Pizza pizza;
    private int antal;
    private boolean erBetalt;
    private boolean erAfhentet;
    private ArrayList<Ordre> ordreliste = new ArrayList<>();


    public Ordre(Kunde kunde, Pizza pizza, int antal) {
        this.kunde = kunde;
        this.pizza = pizza;
        this.antal = antal;
        this.erBetalt = false; //Når en ordre oprettes, er den som standard ikke betalt.
        this.erAfhentet = false; //Når en ordre oprettes, er den som standard ikke afhentet.
    }

    public void Betalt (){
        this.erBetalt = true; //Sætter erBetalt til true, så man kan se at ordren er betalt.
    }

    public void Afhentet(){
        this.erAfhentet = true;
    }

    public boolean Afsluttet(){
        return erBetalt && erAfhentet; // Returnerer true hvis ordren både er betalt og afhentet.
    }

    public Kunde hentKundeId() { //Returnerer ordrens kunde id.
        return kunde;
    }

    @Override
    public String toString() {
        return "Tlf: " + kunde.getId() +
                "\nNavn: " + kunde.getNavn() +
                "\nAfhentning: " + kunde.getAfhentning() +
                "\nBestilling: " + antal + " x " + pizza.getNr();

        }


    }

