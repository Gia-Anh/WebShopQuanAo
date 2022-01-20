package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.NguoiDungDAO;
import com.shop.dto.KhachHangDTO;
import com.shop.dto.TaiKhoanDTO;
import com.shop.entity.NguoiDung;
import com.shop.entity.Role;

@Repository
@Transactional
public class NguoiDungDAOImpl implements NguoiDungDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<NguoiDung> layDSNguoiDung() {
		Session session = sessionFactory.getCurrentSession();
		Query<NguoiDung> query = session.createQuery("FROM NguoiDung", NguoiDung.class);
		List<NguoiDung> nguoiDungs = query.getResultList();
		return nguoiDungs;
	}

	@Override
	public NguoiDung layThongTinNguoiDung(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(NguoiDung.class, id);

	}

	@Override
	public void themNguoiDung(NguoiDung nguoiDung, int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, roleId);
		nguoiDung.setRole(role);
		nguoiDung.setMatKhau(passwordEncoder.encode(nguoiDung.getMatKhau()));
		session.saveOrUpdate(nguoiDung);
	}

	@Override
	public void suaNguoiDung(NguoiDung nguoiDung, int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, roleId);
		NguoiDung nd = session.get(NguoiDung.class, nguoiDung.getId());
		nd.setDiaChi(nguoiDung.getDiaChi());
		nd.setRole(role);
		nd.setMatKhau(nguoiDung.getMatKhau());
		nd.setSoDienThoai(nguoiDung.getSoDienThoai());
		nd.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		session.saveOrUpdate(nd);
	}
	
	@Override
	public void suaThongTinCobanNguoiDung(NguoiDung nguoiDung, int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, roleId);
		NguoiDung nd = role.getNguoiDung(nguoiDung.getId());
		nd.setDiaChi(nguoiDung.getDiaChi());
		nd.setRole(role);
		nd.setSoDienThoai(nguoiDung.getSoDienThoai());
		nd.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		session.saveOrUpdate(nd);
	}

	@Override
	public void xoaNguoiDung(int id) {
		Session session = sessionFactory.getCurrentSession();
		NguoiDung nguoiDung = session.get(NguoiDung.class, id);
		session.delete(nguoiDung);
		
	}

	@Override
	public boolean checkEmail(String email) {
		List<NguoiDung> nguoiDungs = layDSNguoiDung();
		for (NguoiDung nguoiDung : nguoiDungs) {
			if (nguoiDung.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkTaiKhoan(String email, String password) {
		List<NguoiDung> nguoiDungs = layDSNguoiDung();
		for (NguoiDung nguoiDung : nguoiDungs) {
			if (nguoiDung.getEmail().equals(email)) {
				if (nguoiDung.getMatKhau().equals(password)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public NguoiDung layThongTinNguoiDung(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<NguoiDung> query = session.createQuery("FROM NguoiDung where email=:mail", NguoiDung.class);
		query.setParameter("mail", email);
		NguoiDung nd = query.getSingleResult();
		return nd;
	}

	@Override
	public void dangKy(TaiKhoanDTO taiKhoanDTO) {
		Session session = sessionFactory.getCurrentSession();
		NguoiDung nd = new NguoiDung();
		Role role = session.find(Role.class, taiKhoanDTO.getRole_id());
		
		nd.setTenNguoiDung(taiKhoanDTO.getTenNguoiDung());
		nd.setEmail(taiKhoanDTO.getEmail());
		nd.setMatKhau(passwordEncoder.encode(taiKhoanDTO.getMatKhau()));
		nd.setRole(role);
		
		session.save(nd);
		
	}

	@Override
	public void capNhatNguoiDung(int nguoiDungID, KhachHangDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		NguoiDung nd = session.get(NguoiDung.class, nguoiDungID);
		nd.setTenNguoiDung(dto.getTenKhachHang());
		nd.setEmail(dto.getEmail());
		nd.setSoDienThoai(dto.getSoDienThoai());
		nd.setDiaChi(dto.getDiaChi());
		session.saveOrUpdate(nd);
	}
}
