package com.example.test1b.model;

public class Model {
    private static final String USERNAME = "aditi";
    private static final String PASSWORD = "thapa123";
    private static final int MAX_ATTEMPTS = 5;
    private int invalidAttempts = 0;


    public boolean validate(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            invalidAttempts = 0;
            return true;
        } else {
            invalidAttempts++;
            return false;
        }
    }

    public boolean isAccountLocked() {
        return invalidAttempts >= MAX_ATTEMPTS;
    }

    public int getInvalidAttempts() {
        return invalidAttempts;
    }
    public static int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

}