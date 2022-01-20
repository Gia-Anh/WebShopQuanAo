package com.shop.dao.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.DonHangDAO;
import com.shop.dto.CTGioHang;
import com.shop.dto.GioHang;
import com.shop.entity.CT_DonHang;
import com.shop.entity.DonHang;
import com.shop.entity.NguoiDung;
import com.shop.entity.SanPhamSKU;

@Repository
public class DonHangDAOImpl implements DonHangDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DonHang> layDsDonHang() {
		Session session = sessionFactory.getCurrentSession();
		Query<DonHang> query = session.createQuery("FROM DonHang", DonHang.class);
		List<DonHang> dsdh = query.getResultList();
		return dsdh;
	}

	@Override
	public DonHang layThongTinDonHang(int id) {
		Session session = sessionFactory.getCurrentSession();
		DonHang dh = session.get(DonHang.class, id);
		return dh;
	}

	@Override
	public void xoaDonHang(int id) {
		Session session = sessionFactory.getCurrentSession();
		DonHang dh = session.get(DonHang.class, id);
		session.delete(dh);
	}

	@Override
	public void luuDonHang(GioHang gioHang) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		
		DonHang donHang = new DonHang();
		NguoiDung nd = session.get(NguoiDung.class, gioHang.getKhachHangDTO().getKh_id());
		donHang.setNguoiDung(nd);
		
		long millis = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(millis);
		donHang.setNgayDat(currentDate);
		
		session.save(donHang);
		
		List<CTGioHang> dsGioHang = gioHang.getDsCT();
		
		for (CTGioHang ctGioHang : dsGioHang) {
			CT_DonHang ct_DonHang = new CT_DonHang();
			ct_DonHang.setDonHang(donHang);
			SanPhamSKU sanPhamSKU = session.get(SanPhamSKU.class, ctGioHang.getSku().getSku_id());
			ct_DonHang.setSanPhamSKU(sanPhamSKU);
			
			int soLuongTon = sanPhamSKU.getSoLuongTon();
			if (ctGioHang.getSoLuong() > soLuongTon) {
				throw new Exception("Không đủ số lượng!!");
			}else {
				ct_DonHang.setSoLuong(ctGioHang.getSoLuong());
			}	
			ct_DonHang.setDonGia(ctGioHang.getThanhTien());
			session.save(ct_DonHang);
			
			sanPhamSKU.setSoLuongTon(soLuongTon - ctGioHang.getSoLuong());
			session.save(sanPhamSKU);
		}
		
		
	}

	

}
