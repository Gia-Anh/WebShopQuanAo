package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.CT_DonHangDAO;
import com.shop.entity.CT_DonHang;
import com.shop.entity.DonHang;

@Repository
public class CT_DonHangDAOImpl implements CT_DonHangDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<CT_DonHang> layDSCTDonHang(int donHangId) {
		Session session = sessionFactory.getCurrentSession();
		Query<CT_DonHang> query = session.createQuery("FROM CT_DonHang WHERE donhang_id = "+donHangId);
		List<CT_DonHang> ct_DonHangs = query.getResultList();
		return ct_DonHangs;
	}
	
	@Override
	public void themCTDonHang(CT_DonHang ctDonHang, int donHangId) {
		Session session = sessionFactory.getCurrentSession();
		DonHang dh = session.get(DonHang.class, donHangId);
		ctDonHang.setDonHang(dh);
		session.saveOrUpdate(ctDonHang);
	}

}
