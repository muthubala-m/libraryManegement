public class Main {
    public static void main(String[] args) {
        boolean isLogin = false;
        Menu menu = new Menu();
        int choise = 0;
        do {
            choise = menu.authMenu();
            isLogin = menu.switchAuthOperation(choise);
            if (isLogin) {
                menu.libraryMenu();
            }
        } while (choise>0 && choise<3);
    }
}