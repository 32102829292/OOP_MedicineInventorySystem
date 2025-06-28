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
import com.mycompany.medicinesystem.entities.MedicineEntity;
import java.sql.*;
import java.util.*;

public class MedicineController {
    public static boolean addMedicine(MedicineEntity medicine) throws Exception {
        Connection conn = DBConnector.connect();
        String sql = "INSERT INTO \"Register\".\"AddStocks\" (\"MedicineNo\", \"MedicineName\", \"MedicinePrice\", \"MedicineStocks\") VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, medicine.getMedicineNo());
        stmt.setString(2, medicine.getMedicineName());
        stmt.setDouble(3, medicine.getMedicinePrice());
        stmt.setInt(4, medicine.getMedicineStocks());

        boolean result = stmt.executeUpdate() > 0;
        stmt.close(); conn.close();
        return result;
    }

    public static boolean deleteMedicine(int medNo) throws Exception {
        Connection conn = DBConnector.connect();
        String sql = "DELETE FROM \"Register\".\"AddStocks\" WHERE \"MedicineNo\" = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, medNo);

        boolean result = stmt.executeUpdate() > 0;
        stmt.close(); conn.close();
        return result;
    }

    public static boolean updateMedicine(MedicineEntity medicine) throws Exception {
        Connection conn = DBConnector.connect();
        String sql = "UPDATE \"Register\".\"AddStocks\" SET \"MedicineName\" = ?, \"MedicinePrice\" = ?, \"MedicineStocks\" = ? WHERE \"MedicineNo\" = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, medicine.getMedicineName());
        stmt.setDouble(2, medicine.getMedicinePrice());
        stmt.setInt(3, medicine.getMedicineStocks());
        stmt.setInt(4, medicine.getMedicineNo());

        boolean result = stmt.executeUpdate() > 0;
        stmt.close(); conn.close();
        return result;
    }

    public static List<MedicineEntity> getAllMedicines() throws Exception {
        Connection conn = DBConnector.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM \"Register\".\"AddStocks\"");

        List<MedicineEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new MedicineEntity(
                rs.getInt("MedicineNo"),
                rs.getString("MedicineName"),
                rs.getDouble("MedicinePrice"),
                rs.getInt("MedicineStocks")
            ));
        }

        rs.close(); stmt.close(); conn.close();
        return list;
    }
}

