public class Pizzamenu {

    public void visMenu() {
        System.out.println();
        System.out.println("*** Pizzamenu ***");
        for (Pizza pizza : Pizza.values()) {
            System.out.printf("Pizza nr. %d: %s - %d kr.%n", pizza.getNr(), pizza.getNavn(), pizza.getPris());
        }
    }
}
