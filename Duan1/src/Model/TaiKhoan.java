/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hoang
 */
public class TaiKhoan {
    private String tentaiKhoan,matKhau,vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentaiKhoan, String matKhau, String vaiTro) {
        this.tentaiKhoan = tentaiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getTentaiKhoan() {
        return tentaiKhoan;
    }

    public void setTentaiKhoan(String tentaiKhoan) {
        this.tentaiKhoan = tentaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    
    
}
