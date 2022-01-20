package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.NhaCungCapDAO;
import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;
import com.shop.service.NhaCungCapService;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService{

	@Autowired
	private NhaCungCapDAO nhaCungCapDAO;
	
	@Override
	@Transactional
	public List<NhaCungCap> layDsNhaCungCap() {
		return nhaCungCapDAO.layDsNhaCungCap();
	}

	@Override
	@Transactional
	public void luuNhaCungCap(NhaCungCap ncc) {
		nhaCungCapDAO.luuNhaCungCap(ncc);
	}

	@Override
	@Transactional
	public NhaCungCap layThongTinNCC(int id) {
		return nhaCungCapDAO.layThongTinNCC(id);
	}

	@Override
	@Transactional
	public SanPham layTTSanPham(int nccid, int sanphamid) {
		return nhaCungCapDAO.layTTSanPham(nccid, sanphamid);
	}

	@Override
	@Transactional
	public List<SanPham> layDsSanPham(int maNCC) {
		return nhaCungCapDAO.layDsSanPham(maNCC);
	}

	
	//By Quoc
	@Override
	@Transactional
	public void xoaNhaCungCap(int id) {
		nhaCungCapDAO.xoaNhaCungCap(id);	
	}

}
