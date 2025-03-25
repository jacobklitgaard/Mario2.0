import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SystemMenu {
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

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n/// System Menu ///");
            System.out.println("1. Vis menu");
            System.out.println("2. Aktive ordrer");
            System.out.println("3. Tilføj ordre");
            System.out.println("4. Se ordrehistorik");
            System.out.println("5. Se kundehistorik"); // Skal muligvis ikke bruges?
            System.out.println("6. Afslut");
            System.out.print("\nVælg en mulighed: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> visMenu();
                case 2 -> visAktiveOrdrer();
                case 3 -> tilfoejOrdre();
                case 4 -> seOrdreHistorik();
                case 5 -> visKunde();
                case 6 -> {
                    System.out.println("\nSystem afsluttes...");
                    running = false;
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void visMenu() {
        PizzaMenu visMenu = new PizzaMenu();
        visMenu.visPizzaMenu();
    }

//Viser aktive ordre - tager udgangspunkt i tilfoejOrdre og gememr bestillingerne.
    private void visAktiveOrdrer() {
        boolean running = true;
        while (running)  {
            System.out.println("\n--- Aktive ordrer ---");

            // Sorterer ordrene efter tid.
            Collections.sort(ordreliste, Comparator.comparing(o -> o.getKunde().getAfhentning()));

            System.out.println(ordreliste);
            System.out.println("\nFjern ordre: Tast 1");
            System.out.println("Tilbage: Tast 2");
            String valg = scanner.nextLine();
            if (valg.equalsIgnoreCase("1")) {

            } else if (valg.equalsIgnoreCase("2")) {
                running = false;
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


    public void seOrdreHistorik() {

        System.out.println("Viser ordrehistorik... (Skal laves)");
        System.out.println(historik);
        //ArrayList.sort(null);
        ordrehistorik.visPizzaSalg();
        ordrehistorik.visPizzaerSorteretEfterSalg();


        System.out.println("samlet omsætning" + ordrehistorik.getOmsætning() + " kr. ");

    }

    private void visKunde() {
        System.out.println("Viser kunde... (Skal laves)");
    }

    private void tilfoejOrdre() {
        boolean running = true;
        while (running) {
            //Væglger et pizza nummer og opretter et object fra pizzamenuen
            System.out.println("\nIndtast pizzanummer (1-30): " + RESET);
            nr = scanner.nextInt();
            scanner.nextLine();
                    //While loop til at tjekke om pizzaen er i pizzamenuen.
                    //Hvis der tastes forkert pizza, beder om at indtaste pizza nr igen.
                    while (nr <= 0 || nr > pizzamenu.getPizzamenu().size()) {
                        System.out.println("Indtast pizzanummer 1- " + pizzamenu.getPizzamenu().size());
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

