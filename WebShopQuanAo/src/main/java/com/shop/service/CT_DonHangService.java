package com.shop.service;

import java.util.List;

import com.shop.entity.CT_DonHang;

public interface CT_DonHangService {
	public List<CT_DonHang> layDSCT_DonHang(int donHangId);
	public void themCTDonHang(CT_DonHang ct_donHang, int donHangId);
}
