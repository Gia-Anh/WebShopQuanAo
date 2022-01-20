package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.LoaiSanPhamDAO;
import com.shop.entity.LoaiSanPham;
import com.shop.service.LoaiSanPhamService;

@Service
@Transactional
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{

	@Autowired
	private LoaiSanPhamDAO loaiSanPhamDAO;
	
	@Override

	public List<LoaiSanPham> layDsLoaiSP() {
		return loaiSanPhamDAO.layDsLoaiSP();
	}

	@Override
	
	public LoaiSanPham layThongTinLoaiSP(int id) {
		return loaiSanPhamDAO.layThongTinLoaiSP(id);
	}

	@Override
	public void luuLoaiSanPham(LoaiSanPham loaiSP) {
		loaiSanPhamDAO.luuLoaiSanPham(loaiSP);
	}

	@Override
	public void xoaLoaiSanPham(int id) {
		loaiSanPhamDAO.xoaLoaiSanPham(id);
	}

}
