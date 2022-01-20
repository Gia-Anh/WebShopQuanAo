package com.shop.dto;

public class CTGioHang {
	private SanPhamSKUDTO sku;
	private int soLuong;
	private double thanhTien;
	
	public CTGioHang() {
	}

	public CTGioHang(SanPhamSKUDTO sku) {
		this.sku = sku;
		this.soLuong = 1;
		this.thanhTien = sku.getGia();
	}

	public SanPhamSKUDTO getSku() {
		return sku;
	}

	public void setSku(SanPhamSKUDTO sku) {
		this.sku = sku;
	}

	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		thanhTien = sku.getGia() * soLuong;
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "CTGioHang [sku=" + sku.getSku_id() + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
	}
	
	
}
