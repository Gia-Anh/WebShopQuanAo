package com.shop.dao;

import java.util.List;

import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;

public interface NhaCungCapDAO {
	public List<NhaCungCap> layDsNhaCungCap();
	public void luuNhaCungCap(NhaCungCap ncc);
	public NhaCungCap layThongTinNCC(int id);
	public SanPham layTTSanPham(int nccid, int sanphamid);
	public List<SanPham> layDsSanPham(int maNCC);
	
	//By Quoc
	public void xoaNhaCungCap(int id);
}
