import java.util.ArrayList;

public class Ordrehistorik {
    public ArrayList<Pizza> gemteOrdre;    //Vi laver en liste der gemmer alle ordrer.
    private double omsætning;

    //Konstruktør
    public Ordrehistorik() {
        this.gemteOrdre = new ArrayList<>();
        this.omsætning = 0.0;
    }

    public ArrayList<Pizza> getGemteOrdre() {
        return gemteOrdre;
    }

    public void tilføjPizza(Pizza pizza) {
        gemteOrdre.add(pizza);
    }



    //Metode som skal tilføje ordre til ordrehistorikken.
    public void tilføjOrdre(ArrayList<Pizza> bestiltePizzaer) {
        for (Pizza pizza : bestiltePizzaer) {
            pizza.opdaterAntalSolgt(1);
            gemteOrdre.add(pizza);
            omsætning += pizza.getPris();
        }
    }

    //Metode til at hente omsætning.
    public double getOmsætning() {
        return omsætning;
    }

    public void visPizzaSalg() {
        for (Pizza pizza : gemteOrdre) {
            System.out.print(pizza.getPizzanavn() + " (Nr. " + pizza.getNr() + "): " + pizza.getAntalSolgt() + " solgt, pris: " + pizza.getPris() + " kr.");
        }
        System.out.println();
    }

    public void visPizzaerSorteretEfterSalg() {
        gemteOrdre.sort((pizza1, pizza2) -> Integer.compare(pizza2.getAntalSolgt(), pizza1.getAntalSolgt()));

        System.out.println("Pizzaer sorteret efter antal solgt:");
        for (Pizza pizza : gemteOrdre) {
            System.out.println(pizza.getPizzanavn() + " - " + pizza.getAntalSolgt() + " solgt.");
        }
        System.out.println();
    }
}


//Mangler oversigt over tidligere ordre, inkl dato, pizzatype, mest populærer pizza?