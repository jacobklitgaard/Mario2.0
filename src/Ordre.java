import java.util.ArrayList;

public class Ordre {
    private ArrayList<Pizza> pizzaliste; // Her kalder vi på menuen
  //private boolean erBetalt;
    // private boolean erAfhentet;
    private Kunde kunde; // henter kundeobjekter fra Kunde
    private int totalPris;



    public Ordre(ArrayList<Pizza> pizzaliste, Kunde kunde, int totalPris) {
        this.kunde = kunde;
        this.pizzaliste = pizzaliste;
        this.totalPris = totalPris;
      //  this.erBetalt = false; //Når en ordre oprettes, er den som standard ikke betalt.
        //  this.erAfhentet = false; //Når en ordre oprettes, er den som standard ikke afhentet.
    }
    public Kunde getKunde () {
        return kunde;
    }


//    public void Betalt (){
//        this.erBetalt = true; //Sætter erBetalt til true, så man kan se at ordren er betalt.
//    }
//
//    public void Afhentet(){
//        this.erAfhentet = true;
//    }
//
//    public boolean Afsluttet(){
//        return erBetalt && erAfhentet; // Returnerer true hvis ordren både er betalt og afhentet.
//    }


    @Override
    public String toString() {
        for (int i = 0; i < pizzaliste.size()-1; i++) {
            pizzaliste.get(i);
        } return "\n" + pizzaliste + "\n\u001B[3mKundeoplysninger\u001B[0m:\nNavn: " +
                kunde.getNavn() + "\nTelefon: " + kunde.getTlf() + "\nAfhentning: " + kunde.getAfhentning() + "\n" +
                "Total pris: " + totalPris + "kr\n";
    }

//    public void markerSomBetalt(String Kunde) { //Denne metode markerer en ordre som betalt baseret på dens ID.
//        for (Ordre ordrer : ordreliste) { //En for-each-løkke, der løber gennem hver ordre i ordrelisten.
//            if (ordrer.kunde == kunde) { //Her tjekkes, om kunde-ID'et for den aktuelle ordre matcher det kunde-ID, der er sendt som parameter.
//                ordrer.Betalt(); //Hvis ID'erne matcher, kaldes markerSomBetalt()-metoden på den pågældende ordre. Dette sætter erBetalt til true for ordren.
//                break; //Når ordren er fundet og markeret som betalt, stopper løkken, da der ikke er behov for at fortsætte.
//            }
//
//        }
//    }
//    public void markerSomAfhentet(String Kunde) { //Denne metode markerer en ordre som afhentet baseret på dens ID.
//        for (Ordre ordrer : ordreliste) { // En for-each-løkke, der løber gennem hver ordre i ordrelisten.
//            if (ordrer.kunde == kunde) { // //Her tjekkes, om kunde-ID'et for den aktuelle ordre matcher det kunde-ID, der er sendt som parameter.
//                ordrer.Afhentet(); //Hvis ID'erne matcher, kaldes markerSomAfhentet()-metoden på ordren. Dette sætter Afhentet til true.
//                if (ordrer.Afsluttet()) { //Tjekker, om ordren er klar til at blive sat som afsluttet. Dette sker, hvis både Betalt og Afhentet er true (implementeret i Ordrer-klassen).
//                    ordreliste.remove(ordrer); //Hvis ordren er klar til at blive fjernet, fjernes den fra ordrelisten.
//                }
//                break;
//            }
//        }
//    }

    }

