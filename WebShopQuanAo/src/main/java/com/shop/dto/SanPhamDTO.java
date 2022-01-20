package com.shop.dto;

import java.sql.Date;
import java.util.HashMap;

public class SanPhamDTO {
	private int id;
	private String tenSanPham;
	private String moTa;
	private double gia;
	private int loaiSanPham;
	private int nhaCungCap;
	private int soLuong;
	private Date ngayNhap;
	private HashMap<Integer, Integer> size;
	
	private boolean isUpdate;
	
	private String base64Image;
	
	public SanPhamDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(int loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public int getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(int nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public HashMap<Integer, Integer> getSize() {
		return size;
	}

	public void setSize(HashMap<Integer, Integer> size) {
		this.size = size;
	}
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	
}
