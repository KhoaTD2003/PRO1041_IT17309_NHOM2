/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import SeviceInterface.ChiTietSanPhamService;
import Model.ChiTietSanPham;
import Responsitory.ChiTietSanPhamRepository;
import java.util.List;

/**
 *
 * @author Phan Loc
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{

    private ChiTietSanPhamRepository ctspr = new ChiTietSanPhamRepository();
    @Override
    public List<ChiTietSanPham> getAll() {
        return ctspr.getAll();
    }


    @Override
    public String delete(String id) {
        boolean delete = ctspr.delete(id);
        if(delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String add(ChiTietSanPham ctsp) {
        boolean add = ctspr.add(ctsp);
        if(add) {
            return "Thêm Thành Công";
        }else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(ChiTietSanPham ctsp, String id) {
        boolean update = ctspr.update(ctsp, id);
        if(update){
            return "Sửa thành công";
        }else {
            return "Sửa thất bại";
        }
    }
    
}
