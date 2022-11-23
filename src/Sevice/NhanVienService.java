/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.NhanVien;
import Responsitory.NhanVienResponsitory;
import Sevice.NhanVienService;
import java.util.ArrayList;
import java.util.List;

public class NhanVienService {

    private List<NhanVien> lsNhanVien;
    NhanVienResponsitory ql;
    private NhanVienResponsitory NhanVienResponitory;

    public NhanVienService() {
        ql = new NhanVienResponsitory();
    }

    public List<NhanVien> getAll() {
        return ql.getAll();

    }

    public List<NhanVien> getAll(String input) {
        if (input == null) {
            return ql.getAll();
        }
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().contains(input)) {
                temp.add(x);
            }
        }

        return temp;
    }

    public void GetAllFromDB() {
        if (!NhanVienResponitory.getAll().isEmpty()) {
            lsNhanVien = NhanVienResponitory.getAll();
        }
    }

    public List<NhanVien> gettrangthai(String tt) {
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().equalsIgnoreCase(tt)) {
                temp.add(x);
            }
        }
        return temp;
    }

    public List<NhanVien> getgioitinh(String gt) {
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().equalsIgnoreCase(gt)) {
                temp.add(x);
            }
        }
        return temp;
    }

    public String add(NhanVien nv) {

        if (ql.add(nv)) {

            return "thanh cong";
        }
        return "that bai";
    }

    public String update(NhanVien nv) {
        if (ql.update(nv)) {

            return "Sua thành công";
        }
        return "Không sua duoc";
    }

    public String delete(NhanVien nv) {
        if (ql.delete(nv)) {

            return "thanh cong";
        }
        return "that bai";
    }

    public NhanVien getbyma(String ma) {
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

//    private List<NhanVien> _lstNhanVien;
//    private NhanVienResponsitory _NhanVienResponsitory;
//
//    public NhanVienService() {
//
//        _lstNhanVien = new ArrayList<>();
//        _NhanVienResponsitory = new NhanVienResponsitory();
//        //Khi ma form load thi se load data tu DB
//        if (!_NhanVienResponsitory.getAll().isEmpty()) {
//            _lstNhanVien = _NhanVienResponsitory.getAll();
//        }
//    }
//
//    //Phuong thuc lay du lieu
//    public List<NhanVien> getAll() {
//        return _lstNhanVien;
//
//    }
//
//     public List<NhanVien> tk( String ma) { //Phương thức nạp chồng kết hợp tìm kiếm gần đúng
//        if (ma == null) {
//            return lsNhanVien ;
//        }
//        List<NhanVien> temp = new ArrayList<>();
//        for (NhanVien x : lsNhanVien) {
//            if (x.getManv().toLowerCase().contains(ma.toLowerCase()) || x.getTen().toLowerCase().contains(ma.toLowerCase())) {
//                temp.add(x);
//            }
//        }
//        return temp;
//    }
//
//    public void getAllFromDB() {
//        if (!_NhanVienResponsitory.getAll().isEmpty()) {
//            _lstNhanVien = _NhanVienResponsitory.getAll();
//        }
//    }
//
//    public String add(NhanVien nv) {
//        if (_NhanVienResponsitory.add(nv)) {
//            getAllFromDB();
//            return "Thêm thành công";
//        }
//        return "Không thêm duoc";
//    }
//
//    public String Delete(NhanVien nv) {
//        if (_NhanVienResponsitory.delete(nv)) {
//            getAllFromDB();
//            return "Xóa thành công";
//        }
//        return "Không xóa duoc";
//    }
//
//    public String Update(NhanVien nv) {
//        if (_NhanVienResponsitory.update(nv)) {
//            getAllFromDB();
//            return "Sua thành công";
//        }
//        return "Không sua duoc";
//    }
//
//    //Phuong thuc tra ve doi tuong theo Manv
//    public NhanVien GetCuaHangByManv(String id) {
//        for (NhanVien x : _lstNhanVien) {
//            if (x.getManv().equals(id)) {
//                return x;
//            }
//        }
//        return null;
//    }
}
