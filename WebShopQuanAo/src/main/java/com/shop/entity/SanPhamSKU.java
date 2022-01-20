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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SanPhamSKU implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 93702138994227353L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sanpham_id")
	private SanPham sanPham;

	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private SizeSP sizeSP;
	
	private int soLuongTon;
	
	@OneToMany(mappedBy = "sanPhamSKU", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CT_DonHang> dsct = new ArrayList<CT_DonHang>();
	
	
	public SanPhamSKU() {
	}
	
	public SanPhamSKU(SanPham sanPham, SizeSP sizeSP, int soLuongTon) {
		super();
		this.sanPham = sanPham;
		this.sizeSP = sizeSP;
		this.soLuongTon = soLuongTon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public SizeSP getSizeSP() {
		return sizeSP;
	}


	public void setSizeSP(SizeSP sizeSP) {
		this.sizeSP = sizeSP;
	}


	public int getSoLuongTon() {
		return soLuongTon;
	}


	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public List<CT_DonHang> getDsct() {
		return dsct;
	}

	public void setDsct(List<CT_DonHang> dsct) {
		this.dsct = dsct;
	}

	
}
