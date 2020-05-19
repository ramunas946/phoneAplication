package com.example.myapplication;

public class RegisterLogin {
    private String loginusername;
    private String loginpassword;
    private String loginemail;

    public RegisterLogin(String loginusername, String loginpassword, String loginemail) {
        this.loginusername = loginusername;
        this.loginpassword = loginpassword;
        this.loginemail = loginemail;
    }

    public String getUsername() {
        return loginusername;
    }

    public void setDinnerType(String loginusername) {
        this.loginusername = loginusername;
    }

    public String getPassword() {
        return loginpassword;
    }

    public void setDelivery(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getEmail() {
        return loginemail;
    }

    public void getEmail(String loginemail) {
        this.loginemail = loginemail;
    }
}

