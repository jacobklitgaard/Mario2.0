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
        antalSolgt += antal;
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

    public void setPris(int nyPris) {
        this.pris = nyPris;
    }

    @Override
    public String toString() {
        return  "]" +
                "\nPizza: " + pizzanavn +
                        "\nNr: " + nr +
                        "\nAntal: " + antal +
                        "\npris: " + pris + "kr" +
                        "\nI alt: " + (pris * antal) + "kr\n"
                        + "[";
    }
}


