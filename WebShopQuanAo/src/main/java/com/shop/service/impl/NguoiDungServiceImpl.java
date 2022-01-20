package com.shop.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.NguoiDungDAO;
import com.shop.dto.KhachHangDTO;
import com.shop.dto.TaiKhoanDTO;
import com.shop.entity.NguoiDung;
import com.shop.entity.Role;
import com.shop.service.NguoiDungService;


@Service
@Transactional
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungDAO nguoiDungDao;
	
	@Override
	public NguoiDung layThongTinNguoiDung(int id) {
		return nguoiDungDao.layThongTinNguoiDung(id);
	}

	@Override
	public List<NguoiDung> layDsNguoiDung() {
		return nguoiDungDao.layDSNguoiDung();
	}

	@Override
	public void xoaNguoiDung(int id) {
		nguoiDungDao.xoaNguoiDung(id);
	}

	@Override
	public void themNguoiDung(NguoiDung nguoiDung, int roleId) {
		nguoiDungDao.themNguoiDung(nguoiDung, roleId);
	}

	@Override
	public void suaNguoiDung(NguoiDung nguoiDung, int roleId) {
		nguoiDungDao.suaNguoiDung(nguoiDung, roleId);
	}

	@Override
	public boolean checkEmail(String email) {
		return nguoiDungDao.checkEmail(email);
	}

	@Override
	public boolean checkTaiKhoan(String email, String password) {
		if(nguoiDungDao.checkTaiKhoan(email, password))
			return true;
		return false;
	}

	@Override
	public NguoiDung layThongTinNguoiDung(String email) {
		return nguoiDungDao.layThongTinNguoiDung(email);
	}

	@Override
	public void dangKy(TaiKhoanDTO taiKhoanDTO) {
		nguoiDungDao.dangKy(taiKhoanDTO);
	}

	@Override
	public void capNhatNguoiDung(int nguoiDungID, KhachHangDTO dto) {
		nguoiDungDao.capNhatNguoiDung(nguoiDungID, dto);
	}

	@Override
	public void suaThongTinCobanNguoiDung(NguoiDung nguoiDung, int roleId) {
		nguoiDungDao.suaThongTinCobanNguoiDung(nguoiDung, roleId);
	}
}
