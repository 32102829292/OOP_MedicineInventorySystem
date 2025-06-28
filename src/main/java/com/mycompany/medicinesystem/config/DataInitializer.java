/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicinesystem.config;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DataInitializer {
    public static void initializeDatabase() {
        try {
            Connection conn = DBConnector.connect();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS \"Register\";");
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS \"Register\".\"Registered_user\" ("
                    + "id SERIAL PRIMARY KEY,"
                    + "firstname VARCHAR(50),"
                    + "middlename VARCHAR(50),"
                    + "lastname VARCHAR(50),"
                    + "email VARCHAR(100) UNIQUE,"
                    + "password VARCHAR(100)"
                    + ");"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS \"Register\".\"AddStocks\" ("
                    + "\"MedicineNo\" INTEGER PRIMARY KEY,"
                    + "\"MedicineName\" VARCHAR(100),"
                    + "\"MedicinePrice\" NUMERIC(10, 2),"
                    + "\"MedicineStocks\" INTEGER"
                    + ");"
            );

            stmt.close();
            conn.close();

            System.out.println("Schema and tables initialized.");

        } catch (Exception e) {
            System.err.println("Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
