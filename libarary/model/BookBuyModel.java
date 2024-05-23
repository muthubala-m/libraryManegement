package libarary.model;

import java.sql.Connection;
import java.sql.*;

import libarary.Database;

public class BookBuyModel{

    // bookBuy attributes
    private final Connection connection = Database.connectDatabse();
    private Statement statement = null;
    private String query = null;
    private PreparedStatement preparedStatement = null;

    // buy a book
    public int buyABook(int userId,int bookId,boolean isBuy){
        int rows = 0;
        this.query = "insert into bookBuy (userId,bookId,isPayed) values (?,?,?)";
        try{
            this.preparedStatement = connection.prepareStatement(query);
            this.preparedStatement.setInt(1, userId);
            this.preparedStatement.setInt(2, bookId);
            this.preparedStatement.setBoolean(3, isBuy);
            rows = this.preparedStatement.executeUpdate();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return rows;
    }

    // return a book
    public int  returnBook(int buyId){
        int rows = 0;
        this.query = "delete from bookBuy where buyId="+buyId+"";
        try{
            this.statement = connection.createStatement();
            rows = this.statement.executeUpdate(query);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return rows;
    }
}
