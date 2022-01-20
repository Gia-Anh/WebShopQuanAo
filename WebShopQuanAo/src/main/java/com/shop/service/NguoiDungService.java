package com.shop.service;

import java.util.List;

import com.shop.dto.KhachHangDTO;
import com.shop.dto.TaiKhoanDTO;
import com.shop.entity.NguoiDung;

public interface NguoiDungService{
	public NguoiDung layThongTinNguoiDung(int id);
	public List<NguoiDung> layDsNguoiDung();
	public void themNguoiDung(NguoiDung nguoiDung, int roleId);
	public void suaNguoiDung(NguoiDung nguoiDung, int roleId);
	public void xoaNguoiDung(int id);
	public boolean checkEmail(String email);
	public boolean checkTaiKhoan(String email, String password);
	public void suaThongTinCobanNguoiDung(NguoiDung nguoiDung, int roleId);
	
	public NguoiDung layThongTinNguoiDung(String email);
	public void dangKy(TaiKhoanDTO taiKhoanDTO);
	public void capNhatNguoiDung(int nguoiDungID, KhachHangDTO dto);
}
