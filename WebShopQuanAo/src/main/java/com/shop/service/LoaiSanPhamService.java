package com.shop.service;

import java.util.List;

import com.shop.entity.LoaiSanPham;

public interface LoaiSanPhamService {
	public List<LoaiSanPham> layDsLoaiSP();
	public LoaiSanPham layThongTinLoaiSP(int id);
	public void luuLoaiSanPham(LoaiSanPham loaiSP);
	public void xoaLoaiSanPham(int id);
	
}
