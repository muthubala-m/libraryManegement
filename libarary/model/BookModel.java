package libarary.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import libarary.Database;

public class BookModel {
    private String query = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private Connection connection = Database.connectDatabse();
    private ResultSet resultSet = null;

    // get all books
    public void getAllBooks(){
        this.query = "select * from users";
        try{
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // get a single book
    public void getSingleBook(int bookId){
        this.query = "select * from users where bookId="+bookId+"";
        try{
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
