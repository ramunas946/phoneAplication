package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private String username;
    private String password;


    private SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "MyPrefs";
    private static final String Name = "username";
    private static final String pass = "password";
    private static final String remeb = "checked";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Context context) {
        this.sharedpreferences = context.getSharedPreferences(User.MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public String getUsernameForRegistraition() {
        return username;
    }

    public String getPasswordForRegistraition() {
        return password;
    }

    public void setUsernameForRegistraition(String username) {
        this.username = username;
    }

    public void setPasswordForRegistraition(String password) {
        this.password = password;
    }

    public String getUsernameForLogin() {
        return this.sharedpreferences.getString(Name, "");
    }

    public void setUsernameForLogin(String username) {
        this.sharedpreferences.edit().putString(Name, username).apply();
    }

    public String getPasswordForLogin() {
        return this.sharedpreferences.getString(pass, "");
    }

    public void setPasswordForLogin(String password) {
        this.sharedpreferences.edit().putString(pass, password).apply();
    }

    public boolean isRememberedForLogin() {
        return this.sharedpreferences.getBoolean(remeb, false);
    }

    public void setRemembermeKeyForLogin(boolean checked) {
        this.sharedpreferences.edit().putBoolean(remeb, checked).apply();
    }
}