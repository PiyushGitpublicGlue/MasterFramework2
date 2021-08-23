package org.selenium.pom.objects;

public class UserLogin {

    private String userName;
    private String password;

    public UserLogin(){

    }

    public UserLogin(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public UserLogin setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }


}
