package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.NhaCungCapDAO;
import com.shop.entity.DonHang;
import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;

@Repository
public class NhaCungCapDAOImpl implements NhaCungCapDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<NhaCungCap> layDsNhaCungCap() {
		Session session = sessionFactory.getCurrentSession();
		Query<NhaCungCap> query = session.createQuery("from NhaCungCap", NhaCungCap.class);
        List<NhaCungCap> dsncc = query.getResultList();
        return dsncc;
	}

	@Override
	public void luuNhaCungCap(NhaCungCap ncc) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ncc);
	}

	@Override
	public NhaCungCap layThongTinNCC(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(NhaCungCap.class, id);
	}

	@Override
	public SanPham layTTSanPham(int nccid, int sanphamid) {
		NhaCungCap ncc = this.layThongTinNCC(nccid);
		if (ncc!=null) {
			return ncc.getSanPham(sanphamid);
		}
		return null;
	}

	@Override
	public List<SanPham> layDsSanPham(int maNCC) {
		NhaCungCap ncc = this.layThongTinNCC(maNCC);
		List<SanPham> dssp = ncc.getDssp();
		return dssp;
	}

	
	//By Quoc
	@Override
	public void xoaNhaCungCap(int id) {
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("delete from NhaCungCap where id= "+id);
//		query.executeUpdate();
		
		NhaCungCap ncc = session.get(NhaCungCap.class, id);
		session.delete(ncc);
	}

}
