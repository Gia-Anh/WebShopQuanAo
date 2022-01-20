package com.shop.dto;

public class KhachHangDTO {
	private int kh_id;
	private String tenKhachHang;
	private String diaChi;
	private String soDienThoai;
	private String email;
	
	public KhachHangDTO() {
	}

	public KhachHangDTO(int kh_id, String tenKhachHang, String diaChi, String soDienThoai, String email) {
		super();
		this.kh_id = kh_id;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}



	public int getKh_id() {
		return kh_id;
	}

	public void setKh_id(int kh_id) {
		this.kh_id = kh_id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
