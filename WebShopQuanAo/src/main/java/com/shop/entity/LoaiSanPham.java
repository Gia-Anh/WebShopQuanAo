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
import javax.persistence.OneToMany;

@Entity
public class LoaiSanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1835827729477611360L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenLoaiSP;
	
	@OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SanPham> dsSanPham;
	
	public LoaiSanPham() {
	}

	public LoaiSanPham(String tenLoaiSP) {
		super();
		this.tenLoaiSP = tenLoaiSP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	public List<SanPham> getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(List<SanPham> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public SanPham getSanPham(int sanPhamId) {
		if (dsSanPham != null) {
			for (SanPham sanPham : dsSanPham) {
				if (sanPham.getId()==sanPhamId) {
					return sanPham;
				}
			}
		}
		return null;
	}
	
	public void addSanPham(SanPham sanPham) {
		if (dsSanPham==null) {
			dsSanPham = new ArrayList<>();
		}
		dsSanPham.add(sanPham);
	}

	@Override
	public String toString() {
		return "LoaiSanPham [id=" + id + ", tenLoaiSP=" + tenLoaiSP + ", dsSanPham=" + dsSanPham + "]";
	}
	
	
}
