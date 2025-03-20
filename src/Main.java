public class Main {
    public static void main(String[] args) {
        Pizzamenu pizzamenu = new Pizzamenu();
        SystemMenu systemMenu = new SystemMenu(pizzamenu);
        systemMenu.start();
    }
}
