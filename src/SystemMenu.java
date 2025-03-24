import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SystemMenu {
    private Scanner scanner = new Scanner(System.in);
    private Pizza pizza;
    private String afhentningString;
    private Kunde kunde;



    ArrayList<Ordre> ordreliste = new ArrayList<>();



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
            System.out.println("fjern ordre: 1");
            System.out.println("Gå tilbage: 2");
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
    PizzaMenu pizzamenu = new PizzaMenu();


    private void seOrdreHistorik() {

        System.out.println("Viser ordre historik... (Skal laves)");

    }

    private void visKunde() {
        System.out.println("Viser kunde... (Skal laves)");
    }

    private void tilfoejOrdre() {
        boolean running = true;
        while (running) {
            System.out.println("\nIndtast pizzanummer (1-30): ");
            nr = scanner.nextInt();
            scanner.nextLine();
            while (nr <= 0 || nr > pizzamenu.getPizzamenu().size()) {
                System.out.println("Indtast et nummer fra 1 til " + pizzamenu.getPizzamenu().size());
                nr = scanner.nextInt();
                scanner.nextLine();
            }
            pizza = pizzamenu.getPizzamenu().get(nr - 1);
            System.out.println("Indtast antal: ");

            antal = scanner.nextInt();
            scanner.nextLine();

            Pizza pizzaMedAntal = new Pizza(pizza.getNr(), pizza.getPizzanavn(), antal, pizza.getPris());


            pizzaer.add(pizzaMedAntal);

            System.out.println("Tilføje mere? j/n");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("n")) {
                running = false;
                }
            }

        }

        boolean nummer = true;

        while (nummer) {

            try {
                System.out.println("Indtast telefonnummer: ");
                telefonnummer = scanner.nextInt();
                scanner.nextLine();

                if (telefonnummer < 10000000 || telefonnummer > 99999999) {
                    System.out.println("Telefonnummer skal være 8 cifre");
                } else {
                    nummer = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Det var for langt, prøv igen");
                scanner.nextLine();
            }
        }

        System.out.println("Indtast fornavn: ");
        navn = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Indtast afhentning:  ");
                afhentningString = scanner.nextLine();
                afhentning = LocalTime.parse(afhentningString);
                break;
            } catch (
                    DateTimeParseException a) { //Her catcher vi den fejlmenldning der kommer i terminalen hvis Mario skriver klokken i forkert format.
                System.out.println("Skriv i et rigtigt format Fx : 08:00");
            }
        }

        System.out.println(afhentning);

            Kunde kunde = new Kunde(telefonnummer, navn, afhentning);
            Ordre ordre = new Ordre(pizzaer, kunde);

            System.out.println(ordre);

            ordreliste.add(ordre);

    }
}

