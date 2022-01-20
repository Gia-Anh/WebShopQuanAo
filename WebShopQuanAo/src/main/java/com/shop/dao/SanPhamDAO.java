package com.shop.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.shop.dto.SanPhamDTO;
import com.shop.entity.SanPham;

public interface SanPhamDAO {
	public SanPham layThongTinSP(int id);
	public List<SanPham> layDsSanPham();
	public int luuSanPham(SanPhamDTO sanPhamDTO, InputStream inputStream);
	public void xoaSanPham(int id);
	public SanPhamDTO layTTSanPham(int sanPhamId);
	public List<SanPham> timKiemSanPham(String tenSanPham, int page);
	public List<SanPham> locSanPham(int sortId);
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP, int page);
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP);
	public List<SanPham> layDsSanPhamTheoTrang(int page);
	public long getTotalPage();
	public long getTotalPage2(int loaispID);
	public List<SanPham> searchAndSort(String tenSanPham, int sortType, int page);
	public long getTotalSearchPage(String tenSanPham);
}

