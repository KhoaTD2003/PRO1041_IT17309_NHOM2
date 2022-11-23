/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SeviceInterface;

import Model.SanPham;
import java.util.List;

/**
 *
 * @author Phan Loc
 */
public interface SanPhamService {
    public List<SanPham> getAll();
    public String add(SanPham sp);
    public String update(SanPham sp, String id);
    public String delete(String id);
}
