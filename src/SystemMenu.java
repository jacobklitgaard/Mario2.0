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
            System.out.println("2. Tilføj ordre");
            System.out.println("3. Se ordre historik");
            System.out.println("4. Afslut");
            System.out.print("Vælg en mulighed: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> visMenu();
                case 2 -> tilfoejOrdre();
                case 3 -> seOrdreHistorik();
                case 4 -> {
                    System.out.println("System afsluttes...");
                    running = false;
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void visMenu() {
        pizzamenu.visMenu();
    }

    private void tilfoejOrdre() {
        System.out.println("Tilføjer ordre... (Denne metode skal implementeres senere)");
    }

    private void seOrdreHistorik() {
        System.out.println("Viser ordre historik... (Denne metode skal implementeres senere)");
    }
}
