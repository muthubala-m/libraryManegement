package libarary;

import java.sql.ResultSet;

import libarary.model.BookModel;

public class Book {
    private BookModel bookModel = new BookModel();
    private ResultSet resultSet = null;

    public void showAllBooks(){
        System.out.println("----------------------------------");
        System.out.println("\t\tBooks");
        System.out.println("----------------------------------");
        System.out.printf("%4s %10s %8s %4s","bookId","bookName","bookPrice","bookStack");
        System.out.println();
        this.resultSet = bookModel.getAllBooks();
        try{
            if(!(this.resultSet == null)){
                this.displayResultSet(resultSet, false);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void showSingleBook(int bookId){
        this.resultSet = bookModel.getSingleBook(bookId);
        System.out.println("\t\tBooks");
        System.out.println("----------------------------------");
        System.out.printf("%4s %10s %8s %4s","bookId","bookName","bookPrice","bookStack");
        System.out.println();
        try{
            if (!(this.resultSet == null)) {
                this.displayResultSet(resultSet, true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void displayResultSet(ResultSet resultSet,boolean isOne){
        try{
            if(isOne){
                System.out.printf(" %4d %10s %10d %4d", resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(5));
                System.out.println();
            }else{
                do{
                    System.out.printf(" %4d %10s %10d %4d", resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(5));
                    System.out.println();
                }while (resultSet.next());
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
