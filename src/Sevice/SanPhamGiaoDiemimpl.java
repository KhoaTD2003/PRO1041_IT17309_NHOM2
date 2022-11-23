/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.ChiTietSanPham;
import Model.GioHangGiaoDien;
import Model.SanPhamGiaoDien;
import Responsitory.reposanphamGiaoDien;
import SeviceInterface.SanphamGiaodienService;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamGiaoDiemimpl implements SanphamGiaodienService{
    reposanphamGiaoDien rpsp = new reposanphamGiaoDien();
    @Override
    public List<SanPhamGiaoDien> getAll() {
return rpsp.getAll();}

//    @Override
//    public List<GioHangGiaoDien> getAllgh() {
//return rpsp.getAllgh();}
//    
}
