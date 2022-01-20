package com.shop.dto;

import java.util.ArrayList;
import java.util.List;

public class GioHang {
	private KhachHangDTO khachHangDTO;
	private final List<CTGioHang> dsCT = new ArrayList<CTGioHang>();
	
	public GioHang() {
	}

	public KhachHangDTO getKhachHangDTO() {
		return khachHangDTO;
	}

	public void setKhachHangDTO(KhachHangDTO khachHangDTO) {
		this.khachHangDTO = khachHangDTO;
	}

	public List<CTGioHang> getDsCT() {
		return dsCT;
	}
	
	private CTGioHang timSPTheoMa(int sanpham_id) {
		for (CTGioHang ctGioHang : this.dsCT) {
			if (ctGioHang.getSku().getSku_id() == sanpham_id) {
				return ctGioHang;
			}
		}
		return null;
	}
	
	public void themSanPham(SanPhamSKUDTO skuDTO, int soLuong) {
		CTGioHang ctGioHang = this.timSPTheoMa(skuDTO.getSku_id());
		
		if (ctGioHang == null) {
			ctGioHang = new CTGioHang();
			ctGioHang.setSoLuong(0);
			ctGioHang.setSku(skuDTO);
			this.dsCT.add(ctGioHang);
		}
		
		int soLuongMoi = ctGioHang.getSoLuong() + soLuong;
		if (soLuongMoi <= 0) {
			this.dsCT.remove(ctGioHang);
		}else {
			ctGioHang.setSoLuong(soLuongMoi);
		}
	}
	
	public void capNhatSanPham(int sku_id, int soLuong) {
		CTGioHang ctGioHang = this.timSPTheoMa(sku_id);
		if (ctGioHang != null) {
			if (soLuong == 0) {
				this.dsCT.remove(ctGioHang);
			}else {
				ctGioHang.setSoLuong(soLuong);
			}
		}
	}
	
	public void xoaSanPham(SanPhamSKUDTO skuDTO) {
		CTGioHang ctGioHang = this.timSPTheoMa(skuDTO.getSku_id());
		if (ctGioHang != null) {
			this.dsCT.remove(ctGioHang);
		}
	}
	
	public double tinhTongThanhTien() {
		double tongTT = 0;
		for (CTGioHang ctGioHang : this.dsCT) {
			tongTT += ctGioHang.getThanhTien();
		}
		return tongTT;
	}
	
	public void capNhatSoLuong(GioHang gioHang) {
		if (gioHang != null) {
			List<CTGioHang> dsct = gioHang.getDsCT();
			for (CTGioHang ctGioHang : dsct) {
				this.capNhatSanPham(ctGioHang.getSku().getSku_id(), ctGioHang.getSoLuong());
			}
		}
	}

	@Override
	public String toString() {
		return "GioHang [dsCT=" + dsCT + "]";
	}
	
}
