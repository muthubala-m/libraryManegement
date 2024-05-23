package libarary.model;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import libarary.Database;

public class BookModel {
    private String query = null;
    private Statement statement = null;
    // private PreparedStatement preparedStatement = null;
    private Connection connection = Database.connectDatabse();
    private ResultSet resultSet = null;

    // get all books
    public ResultSet getAllBooks() {
        this.query = "select * from books";
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            if (!this.resultSet.next()) {
                System.out.println("no book in library");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    // get a single book
    public ResultSet getSingleBook(int bookId) {
        this.query = "select * from books where bookId=" + bookId + "";
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            if (!this.resultSet.next()) {
                System.out.println("no book in this bookId");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return this.resultSet;
    }
}
