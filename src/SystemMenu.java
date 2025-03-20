import java.util.ArrayList;
import java.util.Scanner;

public class SystemMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final Pizzamenu pizzamenu;

    public SystemMenu(Pizzamenu pizzamenu) {
        this.pizzamenu = pizzamenu;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("/// System Menu ///");
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
                case 2 -> ordreliste();
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
        pizzamenu.visMenu();
    }

    private void ordreliste() {
        System.out.println(ordreliste);
    }

    int nr;
    int antal;
    int telefonnummer;
    String navn;
    String afhentning;
    Pizza pizza1;
    PizzaMenu pizzamenu = new PizzaMenu();


    private void seOrdreHistorik () {
        System.out.println("Viser ordre historik... (Skal laves)");
    }
    private void visKunde () {
        System.out.println("Viser kunde... (Skal laves)");}


    private void tilfoejOrdre() {
        boolean running = true;
        while (running) {
            System.out.println("\nIndtast pizzanummer (1-30): ");
            nr = scanner.nextInt();
            scanner.nextLine();
            while(nr <= 0 || nr > pizzamenu.getPizzamenu().size()){
                System.out.println("Indtast et nummer fra 1 til " + pizzamenu.getPizzamenu().size());
                nr = scanner.nextInt();
                scanner.nextLine();
            }
            pizza1 = pizzamenu.getPizzamenu().get(nr - 1);
            System.out.println("Indtast antal: ");
            antal = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Tilføje mere? j/n");
            String choice = scanner.nextLine().toLowerCase();
            if(choice.equals("n")) {
                running = false;
                }
            }

                System.out.println("Indtast telefonnummer: ");
                telefonnummer = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Indtast fornavn: ");
                navn = scanner.nextLine();
                System.out.println("Indtast afhentning: ");
                afhentning = scanner.nextLine();
                Pizza pizza = new Pizza(nr, "Hawaii", 60);
                Kunde kunde = new Kunde(telefonnummer, navn, afhentning);
                Ordre ordre = new Ordre(kunde, pizza, antal);

                System.out.println(ordre);

                ordreliste.add(ordre);
            }
        }
