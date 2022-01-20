package com.shop.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.shop.dto.GioHang;
import com.shop.entity.DonHang;

public interface DonHangDAO {
	public List<DonHang> layDsDonHang();
	public DonHang layThongTinDonHang(int id);
	public void xoaDonHang(int id);
	public void luuDonHang(GioHang gioHang) throws Exception;
	
}
