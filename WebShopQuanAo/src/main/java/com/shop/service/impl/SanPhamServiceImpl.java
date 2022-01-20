package com.shop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.SanPhamDAO;
import com.shop.dto.SanPhamDTO;
import com.shop.entity.SanPham;
import com.shop.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService{

	@Autowired
	private SanPhamDAO sanPhamDAO;
	
	@Override
	@Transactional
	public SanPham layThongTinSP(int id) {
		return sanPhamDAO.layThongTinSP(id);
	}

	@Override
	@Transactional
	public List<SanPham> layDsSanPham() {
		return sanPhamDAO.layDsSanPham();
	}
	
	@Override
	@Transactional
	public int luuSanPham(SanPhamDTO sanPhamDTO, InputStream inputStream) throws IOException {
		return sanPhamDAO.luuSanPham(sanPhamDTO, inputStream);
	}

	@Override
	@Transactional
	public void xoaSanPham(int id) {
		sanPhamDAO.xoaSanPham(id);
	}

	@Override
	@Transactional
	public SanPhamDTO layTTSanPham(int sanPhamId) throws SQLException, IOException {
		return sanPhamDAO.layTTSanPham(sanPhamId);
	}

	@Override
	@Transactional
	public List<SanPham> timKiemSanPham(String tenSanPham, int page) {
		return sanPhamDAO.timKiemSanPham(tenSanPham, page);
	}

	@Override
	@Transactional
	public List<SanPham> locSanPham(int sortId) {
		return sanPhamDAO.locSanPham(sortId);
	}

	@Override
	@Transactional
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP, int page) {
		return sanPhamDAO.layDsSanPhamTheoLoai(loaiSP, page);
	}

	@Override
	@Transactional
	public List<SanPham> layDsSanPhamTheoTrang(int page) {
		return sanPhamDAO.layDsSanPhamTheoTrang(page);
	}

	@Override
	@Transactional
	public long getTotalPage() {
		return sanPhamDAO.getTotalPage();
	}

	@Override
	@Transactional
	public List<SanPham> searchAndSort(String tenSanPham, int sortType, int page) {
		return sanPhamDAO.searchAndSort(tenSanPham, sortType, page);
	}

	@Override
	@Transactional
	public long getTotalSearchPage(String tenSanPham) {
		return sanPhamDAO.getTotalSearchPage(tenSanPham);
	}

	@Override
	@Transactional
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP) {
		return sanPhamDAO.layDsSanPhamTheoLoai(loaiSP);
	}

	@Override
	@Transactional
	public long getTotalPage2(int loaispID) {
		return sanPhamDAO.getTotalPage2(loaispID);
	}



}
