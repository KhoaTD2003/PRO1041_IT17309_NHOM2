/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Model.NhanVien;
import java.util.ArrayList;
import Responsitory.NhanVienResponsitory;
import java.util.List;
import java.sql.*;

public class NhanVienResponsitory {

    public List<NhanVien> getAll() {

        List<NhanVien> ls = new ArrayList<>();

        try ( Connection conn = DBConnection.getConnection()) {
            String sql = "select manv,ten,diachi,gioitinh,ngaysinh,email,sdt,luong,trangthai from nhanvien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ls.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }

        } catch (Exception e) {
        }
        return ls;

    }

    public boolean add(NhanVien nv) {
        try ( Connection conn = DBConnection.getConnection()) {
            String sql = "insert into nhanvien(manv,ten,diachi,gioitinh,ngaysinh,email,sdt,luong,trangthai) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, nv.getManv());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getDiachi());
            ps.setObject(4, nv.getGioitinh());
            ps.setObject(5, nv.getNgaysinh());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getSdt());
            ps.setObject(8, nv.getLuong());
            ps.setObject(9, nv.getTrangthai());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;

    }

    public boolean update(NhanVien nv) {
        try ( Connection conn = DBConnection.getConnection()) {
            Statement st = conn.createStatement();

            String UPDATE_NHANVIEN = "UPDATE nhanvien set ten = '" + nv.getTen() + "',diachi = '"
                    + nv.getDiachi() + "', gioitinh = '" + nv.getGioitinh() + "',ngaysinh = '"
                    + nv.getNgaysinh() + "', email = '" + nv.getEmail() + "', sdt = '"
                    + nv.getSdt() + "', luong = '" + nv.getLuong() + "', trangthai = '"
                    + nv.getTrangthai() + "' where manv = '" + nv.getManv() + "'";

            System.out.println(UPDATE_NHANVIEN);
            st.executeUpdate(UPDATE_NHANVIEN);
            conn.close();
            return true;

        } catch (Exception e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại Add()");
            return false;
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean delete(NhanVien nv) {

        try ( Connection conn = DBConnection.getConnection()) {
            String sql = "delete from nhanvien where manv =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, nv.getManv());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
//
//    public static void main(String[] args) {
//        List<NhanVien> list = new NhanVienResponsitory().getAll();
//        for (NhanVien nv : list) {
//            System.out.println(nv.toString());
//        }
//    }
//    public boolean add(NhanVien nv) {
//        try ( Connection conn = DBConnection.getConnection()) {
//            String sql = "insert into nhanvien(manv,ten,diachi,gioitinh,ngaysinh,email,sdt,luong,trangthai) values (?,?,?,?,?,?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, nv.getManv());
//            ps.setObject(2, nv.getTen());
//            ps.setObject(3, nv.getDiachi());
//            ps.setObject(4, nv.getGioitinh());
//            ps.setObject(5, nv.getNgaysinh());
//            ps.setObject(6, nv.getEmail());
//            ps.setObject(7, nv.getSdt());
//            ps.setObject(8, nv.getLuong());
//            ps.setObject(9, nv.getTrangthai());
//
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//
//    }
//
//    public boolean update(NhanVien nv) {
//        try ( Connection conn = DBConnection.getConnection()) {
//            Statement st = conn.createStatement();
//
//            String UPDATE_NHANVIEN = "UPDATE nhanvien set ten = '" + nv.getTen() + "',diachi = '"
//                    + nv.getDiachi() + "', gioitinh = '" + nv.getGioitinh() + "',ngaysinh = '"
//                    + nv.getNgaysinh() + "', email = '" + nv.getEmail() + "', sdt = '"
//                    + nv.getSdt() + "', luong = '" + nv.getLuong() + "', trangthai = '"
//                    + nv.getTrangthai() + "' where manv = '" + nv.getManv() + "'";
//
//            System.out.println(UPDATE_NHANVIEN);
//            st.executeUpdate(UPDATE_NHANVIEN);
//            conn.close();
//            return true;
//
//        } catch (Exception e) {
//            System.out.println("Lỗi không thể kết nối vào CSDL tại Add()");
//            return false;
//        }
//    }
//
//    public boolean delete(NhanVien nv) {
//
//        try ( Connection conn = DBConnection.getConnection()) {
//            String sql = "delete from nhanvien where manv =?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, nv.getManv());
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//    }
//
//    public List<NhanVien> getAll() {
//
//        String sql = "select manv,ten,diachi,gioitinh,ngaysinh,email,sdt,luong,trangthai from nhanvien";
//        List<NhanVien> ls = new ArrayList<>();
//        try ( Connection conn = DBConnection.getConnection()) {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            //Gán lại giá trị khi truy vấn về đối tượng
//            while (rs.next()) {
//                ls.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
//            }
//        } catch (Exception e) {
//            System.out.println("Lỗi không thể kết nối vào CSDL tại GetAll()");
//        }
//        return ls;
//    }

    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienResponsitory().getAll();
        for (NhanVien nv : list) {
            System.out.println(nv.toString());
        }
    }

}
