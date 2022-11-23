/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Model.ChiTietSanPham;
import Model.GioHangGiaoDien;
import Model.SanPhamGiaoDien;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author admin
 */
public class reposanphamGiaoDien {
      public List<SanPhamGiaoDien> getAll() {
        ArrayList<SanPhamGiaoDien> listspgd = new ArrayList<>();
        String sql = "SELECT  dbo.SANPHAM.Masp,  dbo.SANPHAM.Ten, dbo.CHITIETSANPHAM.Soluong, dbo.CHITIETSANPHAM.Dongia \n" +
"FROM         dbo.SANPHAM  JOIN\n" +
"                      dbo.CHITIETSANPHAM ON dbo.SANPHAM.id = dbo.CHITIETSANPHAM.Idsp" ;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamGiaoDien spgd = new SanPhamGiaoDien();
                spgd.setMa(rs.getString(1));
                spgd.setTen(rs.getString(2));
              spgd.setSoLuong(rs.getInt(3));
                spgd.setDongia(rs.getInt(4));
                
                
                listspgd.add(spgd);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return listspgd;
    }

//         public List<GioHangGiaoDien> getAllgh() {
//        ArrayList<GioHangGiaoDien> listgh = new ArrayList<>();
//        String sql = "SELECT  dbo.SANPHAM.Masp,  dbo.SANPHAM.Ten,  dbo.CHITIETSANPHAM.Dongia \n" +
//"FROM         dbo.SANPHAM INNER JOIN\n" +
//"                      dbo.CHITIETSANPHAM ON dbo.SANPHAM.Id = dbo.CHITIETSANPHAM.Idsp" ;
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                GioHangGiaoDien gh = new GioHangGiaoDien();
//                gh.setMa(rs.getString(1));
//                gh.setTen(rs.getString(2));
//                 gh.setDongia(rs.getInt(3));
//               
//                
//                
//                listgh.add(gh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//
//        }
//        return listgh;
//    }         
      
}
