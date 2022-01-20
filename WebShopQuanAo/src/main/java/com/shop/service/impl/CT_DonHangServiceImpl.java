package com.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CT_DonHangDAO;
import com.shop.entity.CT_DonHang;
import com.shop.service.CT_DonHangService;

@Service
@Transactional
public class CT_DonHangServiceImpl implements CT_DonHangService {
	@Autowired
	private CT_DonHangDAO ct_donHangDao;
	@Override
	public List<CT_DonHang> layDSCT_DonHang(int donHangId) {
		return ct_donHangDao.layDSCTDonHang(donHangId);
	}
	@Override
	public void themCTDonHang(CT_DonHang ct_donHang, int donHangId) {
		ct_donHangDao.themCTDonHang(ct_donHang, donHangId);
	}

}
