/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class GioHangGiaoDien {
      private String ma;
    private String ten;
        private int Dongia ;
 private int soLuong;

    public GioHangGiaoDien() {
    }

    public GioHangGiaoDien(String ma, String ten, int Dongia, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.Dongia = Dongia;
        this.soLuong = soLuong;
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

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int Dongia) {
        this.Dongia = Dongia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

     public int thanhtien() {
        return soLuong * Dongia;
    }
}
