package com.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SizeSP implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8516103828822033575L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenSize;
	
	@OneToMany(mappedBy = "sizeSP")
	private List<SanPhamSKU> dsSku;
	
	public SizeSP() {
	}

	public SizeSP(String tenSize) {
		super();
		this.tenSize = tenSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

	public List<SanPhamSKU> getDsSku() {
		return dsSku;
	}

	public void setDsSku(List<SanPhamSKU> dsSku) {
		this.dsSku = dsSku;
	}
}
