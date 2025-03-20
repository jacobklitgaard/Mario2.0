public enum Pizza {
    P1(1, "Vesuvio", 57),
    P2(2, "Amerikaner", 53),
    P3(3, "Cacciatore", 57),
    P4(4, "Carbona", 63),
    P5(5, "Dennis", 65);

public class Pizza {

    private int nr;
    private String pizzanavn;
    private int pris;


    public Pizza(int nr, String pizzanavn, int pris) {
        this.nr = nr;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public String getPizzanavn() {
        return pizzanavn;
    }
}}
    /*
    public void visPizzaMenu() {
        if (pizzamenu.isEmpty()) {
            System.out.println("ingen pizzaer, alt udsolgt!");

        } else {

            System.out.println("\n === Marios Pizza Menu === ");
            for (Pizza pizza : pizzamenu){
                System.out.println("Nr. " + pizza.getNr() + "- " + pizza.getPizzanavn() + " " + pizza.getPris() + "kr.");
            }
        }
    }*/


