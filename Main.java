public class Main {
    public static void main(String[] args) {
        boolean isLogin = false;
        Menu menu = new Menu();
        int choise = 0;
        do {
            choise = menu.authMenu();
            isLogin = menu.switchAuthOperation(choise);
            if (isLogin) {
                int libChoise = 0;
                do{
                    libChoise = menu.libraryMenu();
                    menu.switchLibraryOperation(libChoise);
                }while(libChoise>0 && libChoise<5);
            }
        } while (choise>0 && choise<3);
    }
}