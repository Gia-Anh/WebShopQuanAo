package com.shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(CT_DonHang_PK.class)
public class CT_DonHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 43614738360263760L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "donhang_id")
	private DonHang donHang;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "sku_id")
	private SanPhamSKU sanPhamSKU;
	
	private int soLuong;
	private double donGia;
	
	public CT_DonHang() {
	}

	public CT_DonHang(DonHang donHang, SanPhamSKU sanPhamSKU, int soLuong, double donGia) {
		super();
		this.donHang = donHang;
		this.sanPhamSKU = sanPhamSKU;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPhamSKU getSanPhamSKU() {
		return sanPhamSKU;
	}

	public void setSanPhamSKU(SanPhamSKU sanPhamSKU) {
		this.sanPhamSKU = sanPhamSKU;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	
	
	
}
