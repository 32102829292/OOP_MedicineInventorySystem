/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicinesystem.utilities;

/**
 *
 * @author Admin
 */
import java.util.regex.Pattern;

public class UserUtilities {

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, email);
    }

    public static boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }

    public static String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }

    public static boolean verifyPassword(String input, String hashedPassword) {
        return hashPassword(input).equals(hashedPassword);
    }
}

