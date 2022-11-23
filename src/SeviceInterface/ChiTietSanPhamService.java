/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SeviceInterface;

import Model.ChiTietSanPham;
import java.util.List;

/**
 *
 * @author Phan Loc
 */
public interface ChiTietSanPhamService {
    public List<ChiTietSanPham> getAll();
    String add(ChiTietSanPham ctsp);
    String delete(String id);
    String update(ChiTietSanPham ctsp, String id);
}
