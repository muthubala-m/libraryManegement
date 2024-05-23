import java.util.Scanner;

import libarary.Book;
import libarary.User;

public class Menu {

    // menu attributes
    
    Scanner scanner = new Scanner(System.in);
    User user = new User();
    Book book = new Book();

    // auth menu

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

    // libary menu option

    public int libraryMenu(){
            int choise = 0;
            System.out.println("----------------------------------");
            System.out.println("\t User Authendication ");
            System.out.println("----------------------------------");
            System.out.println("1.buying a new book");
            System.out.println("2.return a book");
            System.out.println("3.show all books");
            System.out.print("enter your choise ?");
            choise = scanner.nextInt();
            return choise;
    }

    // switch auth operation

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

    // switch library manegement

    public void switchLibraryOperation(int choise){
        int bookId;
        switch (choise) {
            case 1:
                book.showAllBooks();
                System.out.println("enter bookId to buy ?");
                bookId = scanner.nextInt();
                book.showSingleBook(bookId);
                break;
            case 3:
                book.showAllBooks();
                break;
        
            default:
                break;
        }
    }
}
