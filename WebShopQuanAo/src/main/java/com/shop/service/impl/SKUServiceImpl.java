package com.shop.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.SKUDAO;
import com.shop.dto.SanPhamDTO;
import com.shop.dto.SanPhamSKUDTO;
import com.shop.entity.SanPham;
import com.shop.entity.SanPhamSKU;
import com.shop.entity.SizeSP;
import com.shop.service.SKUService;

@Service
public class SKUServiceImpl implements SKUService{
	
	@Autowired
	private SKUDAO dao;
	
	@Override
	@Transactional
	public List<SizeSP> layDsSize() {
		return dao.layDsSize();
	}

	@Override
	@Transactional
	public void luuSanPhamSKU(SanPhamDTO sanPhamDTO) {
		dao.luuSanPhamSKU(sanPhamDTO);
	}

	@Override
	@Transactional
	public List<SanPhamSKU> layDsSKU(int sanPhamId) {
		return dao.layDsSKU(sanPhamId);
	}

	@Override
	@Transactional
	public void xoaSKU(int sanPhamId) {
		dao.xoaSKU(sanPhamId);
	}

	@Override
	@Transactional
	public void capNhatSanPhamSKU(SanPhamDTO sanPhamDTO) {
		dao.capNhatSanPhamSKU(sanPhamDTO);
	}

	@Override
	@Transactional
	public int getSKUId(int sanpham_id, int size_id) {
		return dao.getSKUId(sanpham_id, size_id);
	}

	@Override
	@Transactional
	public SanPhamSKUDTO layTTSku(int sanpham_id, int size_id) {
		return dao.layTTSku(sanpham_id, size_id);
	}

	@Override
	@Transactional
	public SanPhamSKU getSanPhamSKU(int sku_id) {
		return dao.getSanPhamSKU(sku_id);
	}

	@Override
	@Transactional
	public SanPhamSKUDTO layTTSku(int sku_id) {
		return dao.layTTSku(sku_id);
	}

	
}
