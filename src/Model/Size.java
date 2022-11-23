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
public class Size {
    private UUID id;
    private int ten;
    private String ma;

    public Size() {
    }

    public Size(UUID id, int ten, String ma) {
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

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    
}
