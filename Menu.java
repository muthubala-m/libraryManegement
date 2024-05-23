import java.util.Scanner;

import libarary.User;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    User user = new User();

    public int authMenu(){
        int choise = 0;
        System.out.println("----------------------------------");
        System.out.println("\t User Authendication ");
        System.out.println("----------------------------------");
        System.out.println("1.login");
        System.out.println("2.signin");
        System.out.print("enter your choise ?");
        choise = scanner.nextInt();
        return choise;
    }

    public void libraryMenu(){
            int choise = 0;
            System.out.println("----------------------------------");
            System.out.println("\t User Authendication ");
            System.out.println("----------------------------------");
            System.out.println("1.buying a new book");
            System.out.println("2.return a book");
            System.out.println("3.show all books");
            System.out.print("enter your choise ?");
            choise = scanner.nextInt();
            System.out.println(choise);
    }

    public boolean switchAuthOperation(int choise){
        String userName = null;
        String email = null;
        String passWord = null;

        switch (choise) {
            case 1:
                System.out.print("enter userName :");
                userName = scanner.next();
                System.out.print("enter password :");
                passWord = scanner.next();
                user.userLogin(userName, passWord);
                break;
            case 2:
                System.out.print("enter userName :");
                userName = scanner.next();
                System.out.print("enter email :");
                email = scanner.next();
                System.out.print("enter password :");
                passWord = scanner.next();
                user.userSigin(userName, email, passWord);
                break;
            default:
                System.out.println("give a valid inputs 1 to 2");
                break;
        }
        return user.getisLogin();
    }

}
