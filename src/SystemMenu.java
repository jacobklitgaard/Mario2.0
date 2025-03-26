import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SystemMenu {
    // Variabler og importerede klasser
    private Scanner scanner = new Scanner(System.in);
    private Pizza pizza;
    private String afhentningString;
    private Kunde kunde;

    public Pizza getPizza(){
        return pizza;
    }

    ArrayList<Ordre> ordreliste = new ArrayList<>();

    //tom constructor???
    public SystemMenu() {
        this.pizza = pizza;
    }

    //System menuen
    public void start() {
        boolean running = true;

        while (running) {   //While loop til at holde systemet igang
            System.out.println("\n/// System Menu ///");
            System.out.println("1. Vis menu");
            System.out.println("2. Aktive ordrer"); // Ordreliste
            System.out.println("3. Tilføj ordre");
            System.out.println("4. Ordrehistorik");
            System.out.println("5. Kundehistorik (Nice to have)"); // Skal muligvis ikke bruges?
            System.out.println("6. Ændre pris på pizza");
            System.out.println("7. Afslut");
            System.out.print("\nIndtast valg: ");

            int choice = scanner.nextInt();     //Gemmer brugerens input i en int,
            scanner.nextLine();                 //  som bruges i Switch case

            switch (choice) {   //Switch case til at navigere i menuen (aka de forskellige metoder).
                case 1 -> visMenu();
                case 2 -> visAktiveOrdrer();
                case 3 -> tilfoejOrdre();
                case 4 -> seOrdreHistorik();
                case 5 -> visKunde();
                case 6 -> ændrePris();
                case 7 -> {
                    System.out.println("\nSystem afsluttes...");
                    running = false;    //programmet afsluttes når man trykker på 7 (boolean == false).
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen."); //sender fejlbesked og gentager kode
                //hvis der modtages forkert int
            }
        }
    }
    private void ændrePris() {
        Scanner input = new Scanner(System.in); // her laver vi en scanner, hvor vi som bruger kan inputte noget eller ændre koden
        visMenu(); // den viser menuen
        System.out.println("Indtast nr på den pizza, du vil ændre prisen på"); // en print der spørg brugern hvilken pizza han vil ændre
        int PizzaNummer = input.nextInt(); // her har vi en int variabel der giver os muligheden for at indtaste nummeret på pizzaen der skal ændres
        input.nextLine(); // buffer

        ArrayList<Pizza> pizzaliste = pizzamenu.getPizzamenu(); // her henter vi på vores arrayliste som er pizzamenuen fra pizza klassen

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

        int nyPris = input.nextInt(); // Gemmer den nye pris

        ValgtPizza.setPris(nyPris); // vi bruger settter, og nu Opdatere den den nye pris.
        System.out.println("Prisen på " + ValgtPizza.getPizzanavn() + " er nu ændret til " + ValgtPizza.getPris() + "kr"); // bekræfter ændringerne
        //visMenu(); // viser den opdateret meny igen

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
            for (int i = 0; i < ordreliste.size(); i++){
                System.out.println("\u001B[3mBestillingsnummer\u001B[0m: " + i + ordreliste.get(i).toString());
            }

            System.out.println("Fjern ordre: Tast 1");
            System.out.println("Tilbage: Tast 2");
            String valg = scanner.nextLine();
            if (valg.equalsIgnoreCase("1")) {
                    System.out.println("Indtast det \u001B[3mbestillingsnummer\u001B[0m, som du ønsker at fjerne!");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < ordreliste.size()) {
                        ordreliste.remove(index);
                        System.out.println("Bestillingsnummer " + index + " er nu fjernet fra ordrelisten!");
                    } else {
                        System.out.println("Ugyldigt \u001B[3mbestillingsnummer\u001B[0m! Prøv igen: ");
                    }
            } else if (valg.equalsIgnoreCase("2")) {
                running = false;
            } else {
                System.out.println("Forkert input! Prøv igen: ");
            }
        }
    }


    int nr;
    int antal;
    int telefonnummer;
    String navn;
    LocalTime afhentning;
    int totalPris;
    PizzaMenu pizzamenu = new PizzaMenu();
    Ordrehistorik ordrehistorik = new Ordrehistorik();
    ArrayList<Pizza> historik = ordrehistorik.getGemteOrdre();



    public void seOrdreHistorik() {

        System.out.println("Viser ordrehistorik... (Skal laves)");
        System.out.println(historik);
        //ArrayList.sort(null);
        ordrehistorik.visPizzaSalg();
        ordrehistorik.visPizzaerSorteretEfterSalg();


        System.out.println("samlet omsætning" + ordrehistorik.getOmsætning() + " kr. ");

    }

    private void visKunde() {
        System.out.println("Viser kunde... (Nice to have)");
    }

    private void tilfoejOrdre() {
        //Variabler
        final String RESET = "\u001B[0m";

        ArrayList<Pizza> pizzaer = new ArrayList<>();
        boolean running = true;
        //While loop til at tilføje flere bestillinger
        while (running) {
            //Væglger et pizza nummer og opretter et object fra pizzamenuen
            System.out.println("Indtast pizzanummer (1-30): " + RESET);
            nr = scanner.nextInt();
            scanner.nextLine();
                    //While loop til at tjekke om pizzaen er i pizzamenuen.
                    //Hvis der tastes forkert pizza, beder om at indtaste pizza nr igen.
                    while (nr <= 0 || nr > pizzamenu.getPizzamenu().size()) {
                        System.out.println("Indtast pizzanummer (1-" + pizzamenu.getPizzamenu().size() + "): ");
                        nr = scanner.nextInt();
                        scanner.nextLine();
                    }
                    pizza = pizzamenu.getPizzamenu().get(nr - 1); //Tilføjer pizza objekt til
                    //Tilføjer antal af pizza objekt
                    System.out.println("Indtast antal: ");
                    while(true) {
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
                    ordrehistorik.tilføjPizza(pizzaMedAntal);
                    totalPris += pizza.getPris() * antal; //Variable til totalpris
                    //Giver user mulighed til at tilføje flere pizzaer
                    System.out.println("Tilføj mere? j/n");
                    String choice = scanner.nextLine().toLowerCase();
                    if (choice.equals("j")) { //Hvis user vælger "Nej", lukker tilføj pizza loopet,
                                                // og hopper videre til kundeoplysninger.
                    }
                    else{
                        running = false;
                    }
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

                pizza.setAntalSolgt(antal);

            }

        }

