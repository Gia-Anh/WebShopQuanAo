package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.LoaiSanPhamDAO;
import com.shop.entity.LoaiSanPham;
import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;

@Repository
public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LoaiSanPham> layDsLoaiSP() {
		Session session = sessionFactory.getCurrentSession();
		Query<LoaiSanPham> query = session.createQuery("from LoaiSanPham", LoaiSanPham.class);
        List<LoaiSanPham> dsloaisp = query.getResultList();
        return dsloaisp;
	}

	@Override
	public LoaiSanPham layThongTinLoaiSP(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(LoaiSanPham.class, id);
	}

	@Override
	public void luuLoaiSanPham(LoaiSanPham loaiSP) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loaiSP);
	}

	@Override
	public void xoaLoaiSanPham(int id) {
		Session session = sessionFactory.getCurrentSession();
		LoaiSanPham loaiSP = session.get(LoaiSanPham.class, id);
		session.delete(loaiSP);
	}

}
