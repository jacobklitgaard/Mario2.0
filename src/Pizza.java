import java.util.ArrayList;

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


