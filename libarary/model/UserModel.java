package libarary.model;

import java.sql.*;

import libarary.Database;

public class UserModel{

    private Statement statement= null;
    private String query = null;
    private PreparedStatement preparedStatement = null;
    private Connection connection = Database.connectDatabse();
    private ResultSet resultSet = null;

    // get single user record
    public ResultSet getSingleUser(String userName){
        this.query = "select * from users where userName ='"+userName+"'";
        try{
            this.statement = this.connection.createStatement();
            this.resultSet =statement.executeQuery(query);
            if (!(resultSet.next())) {
                this.resultSet = null;
            }else{
                this.resultSet.next();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return this.resultSet;
    }

    // get all user records
    public ResultSet getAllUsers(){
        this.query = "select * from users";
        try{
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            this.resultSet.next();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return this.resultSet;
    }

    // insert a new record

    public int insertUser(String userName,String email,String passWord){
        int rows = 0;
        this.query = "insert into (userName,email,passWord)users values(?,?,?)";
        try {
            this.preparedStatement = this.connection.prepareStatement(this.query);
            this.preparedStatement.setString(1, userName);
            this.preparedStatement.setString(2, email);
            this.preparedStatement.setString(3, passWord);
            rows = this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return rows;
    }
}
