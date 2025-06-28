/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicinesystem.controller;

/**
 *
 * @author Admin
 */
import com.mycompany.medicinesystem.config.DBConnector;
import com.mycompany.medicinesystem.entities.UserEntity;
import java.sql.*;

public class UserController {
    public static boolean registerUser(UserEntity user) throws Exception {
        Connection conn = DBConnector.connect();

        String check = "SELECT 1 FROM \"Register\".\"Registered_user\" WHERE email = ?";
        PreparedStatement checkStmt = conn.prepareStatement(check);
        checkStmt.setString(1, user.getEmail());
        ResultSet rs = checkStmt.executeQuery();
        if (rs.next()) {
            rs.close(); checkStmt.close(); conn.close();
            return false;
        }
        rs.close(); checkStmt.close();

        String sql = "INSERT INTO \"Register\".\"Registered_user\" (firstname, middlename, lastname, email, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getMiddleName());
        stmt.setString(3, user.getLastName());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());

        boolean success = stmt.executeUpdate() > 0;
        stmt.close(); conn.close();
        return success;
    }

    public static boolean login(String email, String password) throws Exception {
        Connection conn = DBConnector.connect();
        String sql = "SELECT password FROM \"Register\".\"Registered_user\" WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String dbPass = rs.getString("password").trim();
            rs.close(); stmt.close(); conn.close();
            return dbPass.equals(password);
        }

        rs.close(); stmt.close(); conn.close();
        return false;
    }
}

