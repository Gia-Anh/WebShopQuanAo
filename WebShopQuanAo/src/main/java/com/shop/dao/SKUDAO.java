package com.shop.dao;

import java.util.List;

import com.shop.dto.SanPhamDTO;
import com.shop.dto.SanPhamSKUDTO;
import com.shop.entity.SanPhamSKU;
import com.shop.entity.SizeSP;

public interface SKUDAO {
	public List<SizeSP> layDsSize();
	public void luuSanPhamSKU(SanPhamDTO sanPhamDTO);
	public List<SanPhamSKU> layDsSKU(int sanPhamId);
	public void xoaSKU(int sanPhamId);
	public void capNhatSanPhamSKU(SanPhamDTO sanPhamDTO);
	public int getSKUId(int sanpham_id, int size_id);
	public SanPhamSKUDTO layTTSku(int sanpham_id, int size_id);
	public SanPhamSKUDTO layTTSku(int sku_id);
	public SanPhamSKU getSanPhamSKU(int sku_id);
	
}
