package com.shop.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CT_DonHang_PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7562141884472722552L;

	private int donHang;
	private int sanPhamSKU;
	
	public CT_DonHang_PK() {
	}

	public CT_DonHang_PK(int donHang, int sanPhamSKU) {
		super();
		this.donHang = donHang;
		this.sanPhamSKU = sanPhamSKU;
	}

	public int getDonHang() {
		return donHang;
	}

	public void setDonHang(int donHang) {
		this.donHang = donHang;
	}

	public int getSanPhamSKU() {
		return sanPhamSKU;
	}

	public void setSanPhamSKU(int sanPhamSKU) {
		this.sanPhamSKU = sanPhamSKU;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + donHang;
		result = prime * result + sanPhamSKU;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CT_DonHang_PK other = (CT_DonHang_PK) obj;
		if (donHang != other.donHang)
			return false;
		if (sanPhamSKU != other.sanPhamSKU)
			return false;
		return true;
	}

	
	
	
	
}
