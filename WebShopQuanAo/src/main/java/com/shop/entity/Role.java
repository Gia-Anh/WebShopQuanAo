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
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6731287004186863114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenRole;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<NguoiDung> dstk;
	
	public Role() {
	}

	public Role(int id, String tenRole) {
		super();
		this.id = id;
		this.tenRole = tenRole;
	}

	public Role(String tenRole) {
		super();
		this.tenRole = tenRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenRole() {
		return tenRole;
	}

	public void setTenRole(String tenRole) {
		this.tenRole = tenRole;
	}

	public List<NguoiDung> getDstk() {
		return dstk;
	}

	public void setDstk(List<NguoiDung> dstk) {
		this.dstk = dstk;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", tenRole=" + tenRole + ", dstk=" + dstk + "]";
	}
	
	public NguoiDung getNguoiDung(int nguoiDungId) {
		if (dstk != null) {
			for (NguoiDung nguoiDung : dstk) {
				if (nguoiDung.getId() == nguoiDungId) {
					return nguoiDung;
				}
			}
		}
		return null;
	}
}
