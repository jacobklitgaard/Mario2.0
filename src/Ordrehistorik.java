//import java.util.ArrayList;
//
//public class Ordrehistorik {
//    public ArrayList<Pizza> gemteOrdre;    //Vi laver en liste der gemmer alle ordrer.
//    private double omsætning;
//
//    //Konstruktør
//    public Ordrehistorik() {
//        this.gemteOrdre = new ArrayList<>();
//        this.omsætning = 0.0;
//    }
//
//    public ArrayList<Pizza> getGemteOrdre() {
//        return gemteOrdre;
//    }
//
//    public void tilføjPizza(Pizza pizza) {
//        gemteOrdre.add(pizza);
//    }
//
//    //Metode til at hente omsætning.
//    public double getOmsætning() {
//        return omsætning;
//    }
//
//
//    //Metode som skal tilføje ordre til ordrehistorikken.
//    public void gemteOrdre(ArrayList<Pizza> bestiltePizzaer) {
//        for (Pizza pizza : bestiltePizzaer) {
//            pizza.opdaterAntalSolgt(1);
//            gemteOrdre.add(pizza);
//            omsætning += pizza.getPris() * pizza.getAntalSolgt();
//        }
//    }
//}
//
//
////Mangler oversigt over tidligere ordre, inkl dato, pizzatype, mest populærer pizza?