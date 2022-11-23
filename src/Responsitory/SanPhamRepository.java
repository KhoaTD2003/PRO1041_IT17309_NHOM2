/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Model.ChiTietSanPham;
import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phan Loc
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Masp]\n"
                + "      ,[Ten]\n"
                + "      ,[Soluong]\n"
                + "  FROM [dbo].[SANPHAM]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> listSp = new ArrayList<>();
            while (rs.next()) {
                listSp.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SanPham sp) {
        String query = "INSERT INTO [dbo].[SANPHAM]\n"
                + "           ([Masp]\n"
                + "           ,[Ten]\n"
                + "           ,[Soluong])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con =DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPham sp, String id) {
        String query = "UPDATE [dbo].[SANPHAM]\n"
                + "   SET \n"
                + "       [Masp] = ?\n"
                + "      ,[Ten] = ?\n"
                + "      ,[Soluong] = ?\n"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[SANPHAM]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try ( Connection con =DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham ctsp :
            list) {
            System.out.println(ctsp.toString());
        }
    }
}
