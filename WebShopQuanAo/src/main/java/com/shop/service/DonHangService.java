package com.shop.service;


import java.util.List;

import com.shop.dto.GioHang;
import com.shop.entity.DonHang;

public interface DonHangService {
	public DonHang layThongTinDonHang(int id);
	public List<DonHang> layDsDonHang();
	public void xoaDonHang(int id);
	public void luuDonHang(GioHang gioHang) throws Exception;
}
