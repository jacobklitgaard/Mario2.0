public class Pizza {
    private int nummer;
    private String pizzanavn;
    private double pris;

    public Pizza(int nummer, String pizzanavn, double pris){
        this.nummer = nummer;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }
    public int getNummer(){
        return nummer;
    }
    public String getPizzanavn(){
        return pizzanavn;
    }
    public double pris(){
        return pris;
    }
}
