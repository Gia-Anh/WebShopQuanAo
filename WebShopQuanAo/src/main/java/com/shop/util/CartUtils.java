package com.shop.util;

import javax.servlet.http.HttpServletRequest;

import com.shop.dto.GioHang;

public class CartUtils {
	
	public static GioHang layGioHang(HttpServletRequest request) {
		GioHang gioHang = (GioHang) request.getSession().getAttribute("myCart");
		
		if (gioHang == null) {
			gioHang = new GioHang();
			request.getSession().setAttribute("myCart", gioHang);
		}
		return gioHang;
	}
	
	public static void xoaGioHang(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
	
	
}
