/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class SanPhamGiaoDien {
     private String id;
    private String ma;
    private String ten;
    private int soLuong;
    private int Dongia ;
    //privie
    public SanPhamGiaoDien() {
    }

    public SanPhamGiaoDien(String id, String ma, String ten, int soLuong, int Dongia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.Dongia = Dongia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int Dongia) {
        this.Dongia = Dongia;
    }

 

 
 
    
}
