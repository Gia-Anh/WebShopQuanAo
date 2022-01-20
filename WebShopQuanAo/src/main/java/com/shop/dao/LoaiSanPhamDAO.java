package com.shop.dao;

import java.util.List;

import com.shop.entity.LoaiSanPham;

public interface LoaiSanPhamDAO {
	public List<LoaiSanPham> layDsLoaiSP();
	public LoaiSanPham layThongTinLoaiSP(int id);
	public void luuLoaiSanPham(LoaiSanPham loaiSP);
	public void xoaLoaiSanPham(int id);
}
