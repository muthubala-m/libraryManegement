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
            if (resultSet != null) {
                String passWordCopy = this.resultSet.getString(4);
                if (passWord.equals(passWordCopy)) {
                    this.isLogin = true;
                    System.out.println("login success");
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
            this.isLogin = true;
        }else{
            System.out.println("sigin  fail");
        }
    }

    // getter & setter  login
    public boolean getisLogin(){
        return this.isLogin;
    }
    public void setisLogin(boolean isLogin){
        this.isLogin = isLogin;
    }
}
