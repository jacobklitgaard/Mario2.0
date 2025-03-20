public enum Pizza {
    P1(1, "Vesuvio", 57),
    P2(2, "Amerikaner", 53),
    P3(3, "Cacciatore", 57),
    P4(4, "Carbona", 63),
    P5(5, "Dennis", 65);

    private final int nr;
    private final String navn;
    private final int pris;

    Pizza(int nr, String navn, int pris) {
        this.nr = nr;
        this.navn = navn;
        this.pris = pris;
    }

    public int getNr() {
        return nr;
    }

    public String getNavn() {
        return navn;
    }

    public int getPris() {
        return pris;
    }
}
