package model;

public class LoginParam {

    private String userName;
    private String password;
    public LoginParam(String name,String password){
        this.userName = name;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return password;
    }

    public void setUserPwd(String password) {
        this.password= password;
    }

}
