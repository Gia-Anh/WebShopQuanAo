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
public class NhaCungCap implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenNCC;
	private String diaChi;
	
	@OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SanPham> dssp;
	
	public NhaCungCap() {
	}

	public NhaCungCap(String tenNCC, String diaChi) {
		super();
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
	}

	public NhaCungCap(int id, String tenNCC, String diaChi) {
		super();
		this.id = id;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public List<SanPham> getDssp() {
		return dssp;
	}

	public void setDssp(List<SanPham> dssp) {
		this.dssp = dssp;
	}

	public SanPham getSanPham(int sanPhamId) {
		if (dssp != null) {
			for (SanPham sanPham : dssp) {
				if (sanPham.getId()==sanPhamId) {
					return sanPham;
				}
			}
		}
		return null;
	}
	
	public void addSanPham(SanPham sanPham) {
		if (dssp==null) {
			dssp = new ArrayList<>();
		}
		dssp.add(sanPham);
	}

	@Override
	public String toString() {
		return "NhaCungCap [id=" + id + ", tenNCC=" + tenNCC + ", dssp=" + dssp + "]";
	}
	
	
}
