package com.shop.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class SanPham implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436646047127773848L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String tenSanPham;
	private String moTa;
	private double gia;
	

	@Lob
	private Blob hinhAnh;

	@ManyToOne
	@JoinColumn(name = "ncc_id")
	private NhaCungCap nhaCungCap;

	@ManyToOne
	@JoinColumn(name = "loaisp_id")
	private LoaiSanPham loaiSanPham;

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SanPhamSKU> dsSku;

	public SanPham() {
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

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public List<SanPhamSKU> getDsSku() {
		return dsSku;
	}

	public void setDsSku(List<SanPhamSKU> dsSku) {
		this.dsSku = dsSku;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getTongSoLuong() {
		int soLuong = 0;
		for (SanPhamSKU sanPhamSKU : this.dsSku) {
			soLuong += sanPhamSKU.getSoLuongTon();
		}
		return soLuong;
	}
	
}
