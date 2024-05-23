package libarary;

import java.sql.ResultSet;

import libarary.model.UserModel;

public class User {

    UserModel userModel = new UserModel();
    private boolean isLogin = false;
    private ResultSet resultSet;

    // user login
    public void userLogin(String userName,String passWord){
        this.resultSet = userModel.getSingleUser(userName);
        try{
            String userNameCopy = this.resultSet.getString(2);
            String passWordCopy = this.resultSet.getString(4);
            if (userName.equals(userNameCopy)) {
                if (passWord.equals(passWordCopy)) {
                    this.isLogin = true;
                }else{
                    System.out.println("password mismatch");
                }
            }else{
                System.out.println("userName not found please signup");
            }

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // user signin
    public void userSigin(String userName,String email,String passWord){
        int rows = userModel.insertUser(userName, email, passWord);
        if (rows == 1) {
            System.out.println("signin success");
        }else{
            System.out.println("sigin  fail");
        }
    }

    // getter is login
    public boolean getisLogin(){
        return this.isLogin;
    }
}
