import java.util.ArrayList;

public class Pizza {

    private int nr;
    private String pizzanavn;
    private int antal;
    private int pris;

    //menukort konstruktør
    public Pizza(int nr, String pizzanavn, int pris) {
        this.nr = nr;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }

    //pizza konstruktør
    public Pizza(int nr, String pizzanavn, int antal, int pris) {
        this.nr = nr;
        this.antal = antal;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
        this.antalSolgt = 0;
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

    public int getAntalSolgt() {
        return antalSolgt;
    }

    public void opdaterAntalSolgt(int antal) {
        this.antalSolgt += antal;
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
                "\nTotal pris: " + (pris * antal);
    }
}


