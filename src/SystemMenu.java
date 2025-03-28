import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SystemMenu {
    // ANSI-farvekoder
    public static final String RESET = "\u001B[0m";    // Nulstil farve
    public static final String RØD = "\u001B[31m";     // Rød tekst
    public static final String GRØN = "\u001B[32m";    // Grøn tekst
    public static final String GUL = "\u001B[33m";     // Gul tekst
    public static final String CYAN = "\u001B[36m";    // Cyan tekst

    // Variabler og importerede klasser
    private Scanner scanner = new Scanner(System.in);
    private Pizza pizza;
    private String afhentningString;

    private ArrayList<Ordre> ordreliste = new ArrayList<>();

    //System menuen
    public void start() {
        boolean running = true;

        while (running) {   // While loop til at holde systemet igang
            System.out.println("════════════════════════════════════════");
            System.out.println(RØD + "         🍕 Mario's Pizzaria 🍕        " + RESET);
            System.out.println("════════════════════════════════════════");
            System.out.println(CYAN + "/// Systemmenu ///" + RESET);
            System.out.println(GRØN + "1. Vis menu" + RESET);
            System.out.println(GUL + "2. Bestillinger" + RESET); // Ordreliste
            System.out.println(RØD + "3. Tilføj ordre" + RESET);
            System.out.println(GRØN + "4. Omsætning" + RESET);
            System.out.println(GUL + "5. Prisændring" + RESET);
            System.out.println(RØD + "6. Afslut program" + RESET);
            System.out.print(CYAN + "\nIndtast valg: " + RESET);


            try {   //Gemmer brugerens input i en int
                int choice = scanner.nextInt();
                scanner.nextLine();      // som bruges i Switch case
                switch (choice) {   //Switch case til at navigere i menuen (aka de forskellige metoder).
                    case 1 -> visMenu();
                    case 2 -> visAktiveOrdrer();
                    case 3 -> tilfoejOrdre();
                    case 4 -> samletSalg();
                    case 5 -> ændrePris();
                    case 6 -> {
                        System.out.println(GRØN + "\n**** System afsluttes ****");
                        running = false;    // Programmet afsluttes når man trykker på 7 (boolean == false).
                        scanner.close();
                    }
                    default -> System.out.println("Ugyldigt valg. Prøv igen."); // Sender fejlbesked og gentager kode
                    //hvis der modtages forkert int
                }
            } catch (InputMismatchException y) {
                System.out.println("Forkert input");
                scanner.nextLine(); // Buffer
            }
        }
    }

    private void ændrePris() {
        Scanner input = new Scanner(System.in); // Her laver vi en scanner, hvor vi som bruger kan inputte noget eller ændre koden
        visMenu(); // den viser menuen
        System.out.println("Indtast nr på den pizza, du vil ændre prisen på"); // En print der spørg brugern hvilken pizza han vil ændre

        int PizzaNummer;

        while (true) {  //Loop som sørger for, at der bliver indtastet tal.
            try {
                PizzaNummer = Integer.parseInt(input.nextLine()); // Forsøger at læse input som et tal
                break; // Hvis det lykkes, stopper loopet
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input! Indtast venligst et gyldigt tal.");
            }
        }

        Pizza ValgtPizza = null; // Initialiserer en variabel til at holde den valgte pizza. Sættes til null, hvis ingen pizza matches.
        for (Pizza pizza : pizzamenu.getPizzamenu()) { // Går igennem listen af pizzaer i menuen én efter én.
            if (pizza.getNr() == PizzaNummer) { //Tjekker, om pizzaens nummer matcher det nummer, brugeren har indtastet.
                ValgtPizza = pizza; // Hvis der er et match, gemmer vi denne pizza i variablen ValgtPizza.
                break; //Stopper løkken, da vi har fundet den rigtige pizza.
            }
        }

        if (ValgtPizza == null) { //Hvis ingen pizza blev fundet (ValgtPizza stadig null), vises en fejlmeddelelse.
            System.out.println("Pizzaen blev ikke fundet");

            return;

        }
        System.out.println("Indtast ny pris på " + ValgtPizza.getPizzanavn()); // Beder brugern om at indtaste den nye pris

        int nyPris;

        while (true) {  // Sørger for, at man ikke kan skrive et bogstav.
            try {
                nyPris = Integer.parseInt(input.nextLine()); // Forsøger at læse input som et tal
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input! Indtast et tal.");
            }
        }


        ValgtPizza.setPris(nyPris); // vi bruger settter, og nu Opdatere den den nye pris.
        System.out.println("Prisen på " + ValgtPizza.getPizzanavn() + " er nu ændret til " + ValgtPizza.getPris() + " kr"); // bekræfter ændringerne
    }

    // Viser menuen og tager udgangspunkt i opdateret priser fra "ændrePris".
    private void visMenu() {
        pizzamenu.visPizzaMenu(); // henter menu og den ny opdateret menu
    }

    //Viser aktive ordre - tager udgangspunkt i tilfoejOrdre og gememr bestillingerne.
    private void visAktiveOrdrer() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Bestillinger ---");
            // Sorterer ordrene efter tid.

            Collections.sort(ordreliste, Comparator.comparing(o -> o.getKunde().getAfhentning()));

            for (int i = 0; i < ordreliste.size(); i++) {
                System.out.println("\u001B[3mBestillingsnummer\u001B[0m: " + (i + 1) + ordreliste.get(i).toString());
            }
            System.out.println("Fjern ordre: Tast 1");
            System.out.println("Tilbage: Tast 2");
            String valg = scanner.nextLine();
            if (valg.equals("1")) {
                System.out.println("Indtast det \u001B[3mbestillingsnummer\u001B[0m, som du ønsker at fjerne!");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();
                if (index >= 0 && index < ordreliste.size()) {
                    ordreliste.remove(index);
                    System.out.println("Bestillingsnummer " + (index + 1) + " er nu fjernet fra ordrelisten!");
                } else {
                    System.out.println("Ugyldigt \u001B[3mbestillingsnummer\u001B[0m! Prøv igen: ");
                }
            } else if (valg.equals("2")) {
                running = false;
            } else {
                System.out.println("Forkert input! Prøv igen: ");
            }
        }
    }

    private int nr;
    private int antal;
    private int telefonnummer;
    private String navn;
    private LocalTime afhentning;
    private int totalPris = 0;
    private int samletOmsætning = 0;
    private int samletAntal;
    private PizzaMenu pizzamenu = new PizzaMenu();

    public void samletSalg() {

        System.out.println("════════════════════════════════════════");
        System.out.printf("Solgte pizzaer: %d%n", samletAntal);
        System.out.printf("Samlet omsætning: %d kr.%n", samletOmsætning);
    }

    private void tilfoejOrdre() {
        //Variabler
        final String RESET = "\u001B[0m";

        ArrayList<Pizza> pizzaer = new ArrayList<>();

        boolean running = true;
        //While loop til at tilføje flere bestillinger
        while (running) {
            //Vælger et pizza nummer og opretter et object fra pizzamenuen
            while (true) {
                try {
                    System.out.println("Indtast pizzanummer (1-30): " + RESET);
                    nr = Integer.parseInt(scanner.nextLine());  // Konvertere String til Int. Hvis det ikke er et tal = fejl
                    if (nr <= 0 || nr > pizzamenu.getPizzamenu().size()) {
                        System.out.println("Ugyldigt pizzanummer. Indtast pizzanummer (1-" + pizzamenu.getPizzamenu().size() + "): ");
                    } else {
                        break;  // Gå ud af loopet hvis input er gyldigt
                    }
                } catch (NumberFormatException e) { // // Fanger fejl, fra parseInt.
                    System.out.println("Ugyldigt input! Indtast venligst et tal.");
                }
            }

            pizza = pizzamenu.getPizzamenu().get(nr - 1); //Tilføjer pizza objekt til
            //Tilføjer antal af pizza objekt
            System.out.println("Indtast antal: ");
            while (true) {
                try {
                    antal = scanner.nextInt();
                    scanner.nextLine();
                    antal = Math.abs(antal);

                    break;
                } catch (InputMismatchException e1) {
                    System.out.println("Ugyldigt antal. Prøv igen: ");
                    scanner.nextLine();
                }
            }
            //Pizza objektet oprettes og tilføjes til Pizzaer arrayListe
            Pizza pizzaMedAntal = new Pizza(pizza.getNr(), pizza.getPizzanavn(), antal, pizza.getPris());
            pizzaer.add(pizzaMedAntal);
            //Objektet tilføjes til ordreliste arrayListe

            //Giver user mulighed til at tilføje flere pizzaer
            System.out.println("Tilføj mere? j/n");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("j")) { //Hvis ikke vælger "ja", lukker tilføj pizza loopet,
                // og hopper videre til kundeoplysninger.
            } else {
                running = false;
            }
            pizza.setAntalSolgt(antal);
            totalPris += pizza.getPris() * antal; //Variable til totalpris
            samletAntal += antal;
        }
        //tilføjer telefon nummer til bestillingen.
        while (true) {
            try { //Try catch, til at fange inputMisMatchException (input over 2147483647 integeres)
                System.out.println("Indtast telefonnummer: ");
                telefonnummer = scanner.nextInt();
                scanner.nextLine();
                //Hvis nummeret ikke er 8 cifre, vil loopet gentage sig.
                if (telefonnummer < 10000000 || telefonnummer > 99999999) {
                    System.out.println("Forkert nummer");
                } else {
                    break;
                }
            } catch (InputMismatchException e2) {
                System.out.println("Forkert nummer");
                scanner.nextLine();
            }
        }
        //Tilføjer navn til bestillingen.
        System.out.println("Indtast fornavn: ");
        navn = scanner.nextLine();
        //Tilføjer afhentingstidspunkt
        while (true) {
            try { //Try catch til at fange DateTimeParseException, hvis inputtet er forkert format.
                System.out.println("Indtast afhentning:  ");
                afhentningString = scanner.nextLine();
                afhentning = LocalTime.parse(afhentningString);
                break;
            } catch (
                    DateTimeParseException a) { //Her catcher vi den fejlmeldning der kommer i terminalen hvis Mario skriver klokken i forkert format.
                System.out.println("Skriv i formatet TT:MM");
            }
        }
        //her oprettes et kunde objekt med variablerne
        Kunde kunde = new Kunde(telefonnummer, navn, afhentning);
        //her oprettes et ordre objekt med pizza arraylisten, kunde objektet og totalpris variablen.
        //pizzaer arraylisten indeholder alle pizzaer der er i ordren
        //kunde objektet er det som lige er blevet lavet over denne tekst
        //totalpris er variablen, som udregner totalprisen til slut i bestillingen
        Ordre ordre = new Ordre(pizzaer, kunde, totalPris);
        //ordrelisten printes.
        System.out.println(ordre);
        ordreliste.add(ordre);

        samletOmsætning += totalPris;
        totalPris = 0;
    }
}

