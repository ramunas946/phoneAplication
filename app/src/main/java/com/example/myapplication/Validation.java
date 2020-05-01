package com.example.myapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String CREDENTIALS_PATTERNUsername = "^([a-zA-Z0-9]{3,20})+$";


    public static boolean isCredentialsValidUsename(String credentials) {
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERNUsername);
        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
    private static final String CREDENTIALS_PATTERNPassword = "^([a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{5,20})+$";


    public static boolean isCredentialsValidPassword(String credentials) {
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERNPassword);
        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
}

