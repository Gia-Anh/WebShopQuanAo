package com.shop.dao;

import java.util.List;

import com.shop.entity.CT_DonHang;

public interface CT_DonHangDAO {
	public List<CT_DonHang> layDSCTDonHang(int donHangId);
	public void themCTDonHang(CT_DonHang ctDonHang, int donHangId); 

}
