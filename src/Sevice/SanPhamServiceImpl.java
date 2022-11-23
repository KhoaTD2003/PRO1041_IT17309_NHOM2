/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import SeviceInterface.SanPhamService;
import Model.SanPham;
import Responsitory.SanPhamRepository;
import java.util.List;

/**
 *
 * @author Phan Loc
 */
public class SanPhamServiceImpl implements SanPhamService{
    private SanPhamRepository spr = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return spr.getAll();
    }

    @Override
    public String add(SanPham sp) {
        boolean add = spr.add(sp);
        if(add){
            return "Thêm thành công";
        }else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sp, String id) {
        boolean update = spr.update(sp, id);
        if(update){
            return "Sửa thành công";
        }else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = spr.delete(id);
        if(delete){
            return "Xóa thành công";
        }else {
            return "Xóa thất bại";
        }
    }
}
