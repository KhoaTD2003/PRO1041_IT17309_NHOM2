/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.UUID;

/**
 *
 * @author Phan Loc
 */
public class MauSac {
    private UUID id;
    private String ten;
    private String ma;

    public MauSac() {
    }

    public MauSac(UUID id, String ten, String ma) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
}
