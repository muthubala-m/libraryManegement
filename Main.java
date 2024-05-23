public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        int choise = 0;
        do {
            choise = menu.authMenu();
            menu.switchAuthOperation(choise);

        } while (choise>0 && choise<3);
    }
}