/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Model.ChiTietSanPham;
import Model.DeGiay;
import Model.KieuDang;
import Model.MauSac;
import Model.NhanVien;
import Model.SanPham;
import Model.Size;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phan Loc
 */
public class ChiTietSanPhamRepository {

    public List<ChiTietSanPham> getAll() {
        ArrayList<ChiTietSanPham> listLh = new ArrayList<>();
        String sql = "SELECT CTSP.Mactsp, SP.TEN, DG.DOCAODE, S.TENSIZE, KD.TENKIEU, MS.TENMAU, CTSP.DONGIA, CTSP.SOLUONG, CTSP.MOTA, CTSP.TRANGTHAI     \n"
            + "FROM            CHITIETSANPHAM CTSP INNER JOIN\n"
            + "                         DEGIAY DG ON CTSP.Idde = DG.Id INNER JOIN\n"
            + "                         KIEUDANG KD ON CTSP.Idkieu = KD.Id INNER JOIN\n"
            + "                         MAUSAC MS ON CTSP.Idms = MS.Id INNER JOIN\n"
            + "                         SANPHAM SP ON CTSP.Idsp = SP.Id INNER JOIN\n"
            + "                         SIZE S ON CTSP.Idsize = S.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString(1));
                ctsp.setSanPham(rs.getString(2));
                ctsp.setDeGiay(rs.getString(3));
                ctsp.setSize(rs.getString(4));
                ctsp.setKieuDang(rs.getString(5));
                ctsp.setMauSac(rs.getString(6));
                ctsp.setDonGia(rs.getInt(7));
                ctsp.setSoLuong(rs.getInt(8));
                ctsp.setMoTa(rs.getString(9));
                ctsp.setTrangThai(rs.getInt(10));
                listLh.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return listLh;
    }

    public boolean add(ChiTietSanPham ctsp) {
//        String query = "insert into CHITIETSANPHAM(Mactsp,Idsp.Ten,idde.Docaode,idsize.Tensize,idkieu.Tenkieu,idms.Tenmau,dongia,soluong,mota,trangthai)\n" +
//"VALUES (?,?,?,?,?,?,?,?,?,?)";
        String query = "insert into CHITIETSANPHAM(Idsp,idms,idkieu,idsize,idde,Mactsp,soluong,dongia,mota,trangthai)\n"
            + "select sp.id,ms.id,kd.id,sz.id,de.id,?,?,?,?,?  from SANPHAM sp,MAUSAC ms,KIEUDANG kd, SIZE sz,DEGIAY de where sp.Ten=? AND ms.Tenmau=? AND kd.Tenkieu= ? and sz.Tensize = ? AND de.Docaode = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ctsp.getMa());
            ps.setObject(2, ctsp.getSoLuong());
            ps.setObject(3, ctsp.getDonGia());
            ps.setObject(4, ctsp.getMoTa());
            ps.setObject(5, ctsp.getTrangThai());
            ps.setObject(6, ctsp.getSanPham());
            ps.setObject(7, ctsp.getMauSac());
            ps.setObject(8, ctsp.getKieuDang());
            ps.setObject(9, ctsp.getSize());
            ps.setObject(10, ctsp.getDeGiay());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = ""
            + "DELETE FROM [dbo].[CHITIETSANPHAM]\n"
            + "      WHERE Mactsp = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChiTietSanPham ctsp, String id) {
        String query = "UPDATE [dbo].[CHITIETSANPHAM]\n"
            + "   SET Idsp = (SELECT sp.id from SANPHAM sp WHERE sp.Ten =?)\n"
            + "      ,Idms = (SELECT ms.id from MAUSAC ms WHERE ms.Tenmau =?)\n"
            + "      ,Idkieu = (SELECT kd.id from KIEUDANG kd WHERE kd.Tenkieu =?)\n"
            + "      ,Idsize = (SELECT s.id from SIZE s WHERE s.Tensize =?)\n"
            + "      ,Idde = (SELECT dg.id from DEGIAY dg WHERE dg.Docaode =?)\n"
            + "      ,[Mactsp] = ?\n"
            + "      ,[Soluong] = ?\n"
            + "      ,[Dongia] = ?\n"
            + "      ,[Mota] = ?\n"
            + "      ,[Trangthai] = ?\n"
            + " WHERE Mactsp like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ctsp.getSanPham());
            ps.setObject(2, ctsp.getMauSac());
            ps.setObject(3, ctsp.getKieuDang());
            ps.setObject(4, ctsp.getSize());
            ps.setObject(5, ctsp.getDeGiay());
            ps.setObject(6, ctsp.getMa());
            ps.setObject(7, ctsp.getSoLuong());
            ps.setObject(8, ctsp.getDonGia());
            ps.setObject(9, ctsp.getMoTa());
            ps.setObject(10, ctsp.getTrangThai());
            ps.setObject(11, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<ChiTietSanPham> list = new ChiTietSanPhamRepository().getAll();
        for (ChiTietSanPham ctsp : list) {
            System.out.println(ctsp.toString());
        }
    }
}
