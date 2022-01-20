package com.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class NguoiDung implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6905281561311175603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tenNguoiDung;
	
	private String diaChi;
	
	private String soDienThoai;
	private String email;
	private String matKhau;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DonHang> dsDonHang;
	
	public NguoiDung() {
	}

	public NguoiDung(int id, String tenNguoiDung, String diaChi, String soDienThoai, String email, String matKhau) {
		super();
		this.id = id;
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.matKhau = matKhau;
	}

	public NguoiDung(String tenNguoiDung, String diaChi, String soDienThoai, String email, String matKhau) {
		super();
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.matKhau = matKhau;
	}

	public NguoiDung(String tenNguoiDung, String diaChi, String soDienThoai) {
		super();
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NguoiDung(String email, String matKhau) {
		super();
		this.email = email;
		this.matKhau = matKhau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
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

	public List<DonHang> getDsDonHang() {
		return dsDonHang;
	}

	public void setDsDonHang(List<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
