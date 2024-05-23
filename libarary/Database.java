package libarary;

import java.sql.*;

public class Database {

    // connection attributes
    static private final String url = "jdbc:mysql://localhost:3306/library";
    static private final String userName = "root";
    static private final String passWord = "2004";
    static private Connection connection = null;

    // connect to the databse
    static public Connection connectDatabse(){
        try{
            connection = DriverManager.getConnection(url, userName, passWord);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return connection;
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
