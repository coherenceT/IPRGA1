package com.mycompany.iprga1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String cellNumber;
    private boolean isLoggedIn;

    // Check if the username is valid
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check if the password meets the complexity requirements
    public boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }

    // Check if the cellphone number is valid using regex
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Starts with +27 and followed by 9 digits
        Pattern pattern = Pattern.compile("^\\+27\\d{9}$");
        Matcher matcher = pattern.matcher(cellNumber);
        return matcher.matches();
    }

    // Register the user
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. It must contain an underscore and be no more than 5 characters.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. It must be at least 8 characters long and contain a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cellphone number is not correctly formatted. It must start with +27 and be followed by 9 digits.";
        }

        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        return "User successfully registered.";
    }

    // Login the user
    public boolean loginUser(String username, String password) {
        isLoggedIn = this.username != null && this.username.equals(username) && this.password.equals(password);
        return isLoggedIn;
    }

    // Return login status message
    public String returnLoginStatus() {
        if (isLoggedIn) {
            return "Welcome, " + this.username + "! It is great to see you again.";
        } else {
            return "Login failed. Username or password incorrect.";
        }
    }
}
