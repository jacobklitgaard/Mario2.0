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

    public int getAntalSolgt() {
        return antalSolgt;
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
        final String RESET = "\u001B[0m";    // Nulstil farve
        final String YELLOW = "\u001B[33m";  // Gul farve

        return  "\n======================================\n" +
                YELLOW + "Pizza   : " + RESET + pizzanavn + "\n" +
                YELLOW + "Nr      : " + RESET + nr + "\n" +
                YELLOW + "Antal   : " + RESET + antal + "\n" +
                YELLOW + "Pris    : " + RESET + pris + " kr\n" +
                YELLOW + "I alt   : " + RESET + (pris * antal) + " kr\n" +
                "======================================";
    }
}
