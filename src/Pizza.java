import java.util.ArrayList;
//Pizza konstruktor
public class Pizza {

    private int nr;
    private String pizzanavn;
    private int antal;
    private int pris;   //skal det måske være double?//
    private int antalSolgt;

    //menukort og enkelt pizza-konstruktør
    public Pizza(int nr, String pizzanavn, int pris) {
        this.nr = nr;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }

    //pizzaMedAntal konstruktør
    public Pizza(int nr, String pizzanavn, int antal, int pris) {
        this.nr = nr;
        this.antal = antal;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }


    public void setAntalSolgt(int antal) {
        this.antalSolgt += antal;
    }


    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public int getAntal() {
        return antal;
    }

    public String getPizzanavn() {
        return pizzanavn;
    }

    public int getAntalSolgt() {
        return antalSolgt;
    }

    public void opdaterAntalSolgt(int antal) {
        this.antal += antalSolgt;
    }

    public void setPris(int nyPris){
        this.pris = nyPris;

    }


    @Override
    public String toString() {
        return  "\n\nPizza: " + pizzanavn +
                "\nNr: " + nr +
                "\npris: " + pris +
                "\nAntal: " + antal +
                "\nI alt: " + (pris * antal);
    }
}


