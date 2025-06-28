/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicinesystem.entities;

/**
 *
 * @author Admin
 */
public class MedicineEntity {
    private int medicineNo;
    private String medicineName;
    private double medicinePrice;
    private int medicineStocks;

    public MedicineEntity(int medicineNo, String medicineName, double medicinePrice, int medicineStocks) {
        this.medicineNo = medicineNo;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineStocks = medicineStocks;
    }

    public int getMedicineNo() { return medicineNo; }
    public String getMedicineName() { return medicineName; }
    public double getMedicinePrice() { return medicinePrice; }
    public int getMedicineStocks() { return medicineStocks; }

    public void setMedicineName(String name) { this.medicineName = name; }
    public void setMedicinePrice(double price) { this.medicinePrice = price; }
    public void setMedicineStocks(int stocks) { this.medicineStocks = stocks; }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
