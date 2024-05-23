package libarary;

import java.sql.*;

public class Database {

    // connection attributes
    private final String url = "jdbc:mysql://localhost:3306/library";
    private final String userName = "root";
    private final String passWord = "2004";
    private Connection connection = null;

    // connect to the databse
    public Connection connectDatabse(){
        try{
            this.connection = DriverManager.getConnection(url, userName, passWord);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return this.connection;
    }

    // closing the databse connection
    public void disconnectDatabase(){
        try{
            connection.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
