public class Pizza {
    private int id;
    private String pizzanavn;
    private double pris;

    public Pizza(int id, String pizzanavn, double pris){
        this.id = id;
        this.pizzanavn = pizzanavn;
        this.pris = pris;
    }
    public int getId(){
        return id;
    }
    public String getPizzanavn(){
        return pizzanavn;
    }
    public double pris(){
        return pris;
    }
}
