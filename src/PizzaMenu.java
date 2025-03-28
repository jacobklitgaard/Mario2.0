import java.util.ArrayList;

public class PizzaMenu {
    private ArrayList<Pizza> pizzamenu = new ArrayList<>();

    // ANSI-farvekoder
    public static final String RESET = "\u001B[0m";    // Nulstil farve
    public static final String RØD = "\u001B[31m";     // Rød tekst
    public static final String GRØN = "\u001B[32m";    // Grøn tekst
    public static final String GUL = "\u001B[33m";     // Gul tekst
    public static final String BLÅ = "\u001B[34m";     // Blå tekst
    public static final String CYAN = "\u001B[36m";    // Cyan tekst

    public PizzaMenu() {
        // Array over de forskellige Pizzaer
        pizzamenu.add(new Pizza(1, "Vesuvio", 57));
        pizzamenu.add(new Pizza(2, "Amerikaner", 53));
        pizzamenu.add(new Pizza(3, "Cacciatore", 57));
        pizzamenu.add(new Pizza(4, "Carbona", 63));
        pizzamenu.add(new Pizza(5, "Dennis", 90));
        pizzamenu.add(new Pizza(6, "Bertil", 90));
        pizzamenu.add(new Pizza(7, "Silvia", 90));
        pizzamenu.add(new Pizza(8, "Victoria", 90));
        pizzamenu.add(new Pizza(9, "Toronto", 90));
        pizzamenu.add(new Pizza(10, "Capricciose", 90));
        pizzamenu.add(new Pizza(11, "Hawaii", 90));
        pizzamenu.add(new Pizza(12, "Le Blissola", 90));
        pizzamenu.add(new Pizza(13, "Venicia", 90));
        pizzamenu.add(new Pizza(14, "Mafia", 90));
        pizzamenu.add(new Pizza(15, "Napoli", 90));
        pizzamenu.add(new Pizza(16, "Roma", 100));
        pizzamenu.add(new Pizza(17, "Milano", 100));
        pizzamenu.add(new Pizza(18, "Palermo", 100));
        pizzamenu.add(new Pizza(19, "Toscana", 100));
        pizzamenu.add(new Pizza(20, "Sicilliana", 100));
        pizzamenu.add(new Pizza(21, "Diavola", 100));
        pizzamenu.add(new Pizza(22, "Primavera", 100));
        pizzamenu.add(new Pizza(23, "Rustica", 100));
        pizzamenu.add(new Pizza(24, "Amore", 69));
        pizzamenu.add(new Pizza(25, "Bella Italia", 69));
        pizzamenu.add(new Pizza(26, "Paradiso", 69));
        pizzamenu.add(new Pizza(27, "Verona", 69));
        pizzamenu.add(new Pizza(28, "Inferno", 69));
        pizzamenu.add(new Pizza(29, "Margherita", 69));
        pizzamenu.add(new Pizza(30, "La Suprema", 150));
    }

    public ArrayList<Pizza> getPizzamenu() {
        return pizzamenu;
    }

    String menu = "=== Menukort ===";

    // Pizza menu metode med farver
    public void visPizzaMenu() {
        if (pizzamenu.isEmpty()) {
            System.out.println(RØD + "Ingen pizzaer, alt udsolgt!" + RESET);
        } else {
            System.out.printf(BLÅ + "\n%40s\n", menu + RESET);
            System.out.printf(GRØN + "\n%-5s%-25s%-15s%-15s\n" + RESET, "Nr.", "Pizza", "Pris", "Antal solgte");

            for (Pizza pizza : pizzamenu) {
                System.out.printf(GUL + "%-5d" + CYAN + "%-25s" + GRØN + "%-15d" + RØD + "%-15d\n" + RESET,
                        pizza.getNr(),
                        pizza.getPizzanavn(),
                        pizza.getPris(),
                        pizza.getAntalSolgt()
                );
            }
        }
    }
}
