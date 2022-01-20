package com.shop.service.impl;

import java.util.List;

import java.sql.Date;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.DonHangDAO;
import com.shop.dto.GioHang;
import com.shop.entity.DonHang;
import com.shop.service.DonHangService;

@Service
@Transactional
public class DonHangServiceImpl implements DonHangService{

	@Autowired
	private DonHangDAO donHangDAO;
	
	@Override
	public DonHang layThongTinDonHang(int id) {
		return donHangDAO.layThongTinDonHang(id);
	}

	@Override
	public List<DonHang> layDsDonHang() {
		return donHangDAO.layDsDonHang();
	}

	@Override
	public void xoaDonHang(int id) {
		donHangDAO.xoaDonHang(id);
	}

	@Override
	public void luuDonHang(GioHang gioHang) throws Exception {
		donHangDAO.luuDonHang(gioHang);
	}


}
