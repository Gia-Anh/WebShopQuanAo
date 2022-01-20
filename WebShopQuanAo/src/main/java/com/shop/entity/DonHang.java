package com.shop.entity;

import java.io.Serializable;
import java.sql.Date;
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

@Entity
public class DonHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2494711574886093471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date ngayDat;
	
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CT_DonHang> dsct = new ArrayList<CT_DonHang>();
	
	@ManyToOne
	@JoinColumn(name = "nguoidung_id")
	private NguoiDung nguoiDung;
	
	public DonHang() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public List<CT_DonHang> getDsct() {
		return dsct;
	}

	public void setDsct(List<CT_DonHang> dsct) {
		this.dsct = dsct;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	
	//by Quoc
	public int tinhDonGia() {
		int money = 0;
		for (CT_DonHang ct_donHang : dsct) {
			money += ct_donHang.getDonGia();
		}
		return money;
	}
	
	
}
