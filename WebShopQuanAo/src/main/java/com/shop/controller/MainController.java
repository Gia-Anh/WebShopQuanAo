package com.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dto.CTGioHang;
import com.shop.dto.GioHang;
import com.shop.dto.KhachHangDTO;
import com.shop.dto.SanPhamDTO;
import com.shop.dto.SanPhamSKUDTO;
import com.shop.dto.TaiKhoanDTO;
import com.shop.entity.CT_DonHang;
import com.shop.entity.DonHang;
import com.shop.entity.LoaiSanPham;
import com.shop.entity.NguoiDung;
import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;
import com.shop.entity.SanPhamSKU;
import com.shop.entity.SizeSP;
import com.shop.service.CT_DonHangService;
import com.shop.service.DonHangService;
import com.shop.service.LoaiSanPhamService;
import com.shop.service.NguoiDungService;
import com.shop.service.NhaCungCapService;
import com.shop.service.SKUService;
import com.shop.service.SanPhamService;
import com.shop.util.CartUtils;

@Controller
public class MainController {
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private LoaiSanPhamService loaiSPService;
	@Autowired
	private NhaCungCapService nhaCCService;
	@Autowired
	private SKUService skuService;
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private DonHangService donHangService;
	@Autowired
	CT_DonHangService ctDonHangService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/home";
	}
	
	@GetMapping("403")
	public String page403() {
		return "403";
	}

	@GetMapping("/login")
	public String showLoginPage(ModelMap modelMap) {
		return "dangnhap";
	}

	@PostMapping("/register")
	public String register(HttpServletRequest request, ModelMap modelMap) {
		String tenKhachHang = request.getParameter("tenKhachHangDK");
		String email = request.getParameter("emailDK");
		String matKhau = request.getParameter("matKhauDK");
		if (!nguoiDungService.checkEmail(email)) {
			TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
			taiKhoan.setTenNguoiDung(tenKhachHang);
			taiKhoan.setEmail(email);
			taiKhoan.setMatKhau(matKhau);
			taiKhoan.setRole_id(2);
			nguoiDungService.dangKy(taiKhoan);
			modelMap.addAttribute("thBao", "Đăng ký thành công!");
			modelMap.addAttribute("taiKhoan", taiKhoan);
			return "dangnhap";
		}
		modelMap.addAttribute("thBao", "Email đã tồn tại");
		return "dangnhap";
	}

	@GetMapping("/home")
	public String listSanPham(ModelMap modelMap) throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.layDsSanPhamTheoTrang(1);
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		long totalPage = sanPhamService.getTotalPage();
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}

		modelMap.addAttribute("dssp", dsDTO);
		modelMap.addAttribute("page", 1);
		modelMap.addAttribute("totalPage", totalPage);
		return "sanpham-list";
	}

	@GetMapping("/lists")
	public String listSanPhamTheoTrang(ModelMap modelMap, @RequestParam("page") int page)
			throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.layDsSanPhamTheoTrang(page);
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		long totalPage = sanPhamService.getTotalPage();
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}

		modelMap.addAttribute("dssp", dsDTO);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("totalPage", totalPage);
		return "sanpham-list";
	}

	@GetMapping("/search")
	public String timKiemSanPham(ModelMap modelMap, @RequestParam("key") String key, @RequestParam("page") int page)
			throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.timKiemSanPham(key, page);
		long totalPage = sanPhamService.getTotalSearchPage(key);
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}
		modelMap.addAttribute("dssp", dsDTO);
		modelMap.addAttribute("keyname", key);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("totalPage", totalPage);
		return "sanpham-search";
	}

	@GetMapping("/sort")
	public String locSanPham(ModelMap modelMap, @RequestParam("type") int type, @RequestParam("key") String key,
			@RequestParam("page") int page) throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.searchAndSort(key, type, page);
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		long totalPage = sanPhamService.getTotalSearchPage(key);
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}
		modelMap.addAttribute("dssp", dsDTO);
		modelMap.addAttribute("keyname", key);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("totalPage", totalPage);
		return "sanpham-sort";

	}

	@GetMapping("/list")
	public String layDsSanPhamTheoLoai(ModelMap modelMap, @RequestParam("category") int loaiSP, @RequestParam("page") int page)
			throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.layDsSanPhamTheoLoai(loaiSP, page);
		long totalPage = sanPhamService.getTotalPage2(loaiSP);
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}
		modelMap.addAttribute("dssp", dsDTO);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("category", loaiSP);
		modelMap.addAttribute("totalPage", totalPage);
		return "sanpham-lists";
	}

	@GetMapping("/view")
	public String xemSanPham(ModelMap modelMap, @RequestParam("id") int sanPhamId) throws SQLException, IOException {
		SanPhamDTO sanPhamDTO = sanPhamService.layTTSanPham(sanPhamId);
		HashMap<Integer, String> skuMap = new HashMap<Integer, String>();
		List<SanPhamSKU> dsSku = skuService.layDsSKU(sanPhamId);

		for (SanPhamSKU sanPhamSKU : dsSku) {
			skuMap.put(sanPhamSKU.getSizeSP().getId(), sanPhamSKU.getSizeSP().getTenSize());
		}

		SanPham sp = sanPhamService.layThongTinSP(sanPhamId);
		// Lấy ds sản phẩm cùng loại
		List<SanPham> dssp = sanPhamService.layDsSanPhamTheoLoai(sp.getLoaiSanPham().getId());
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();

		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dsDTO.add(dto);
		}

		modelMap.addAttribute("sanPham", sanPhamDTO);
		modelMap.addAttribute("dsSize", skuMap);
		modelMap.addAttribute("dsDTO", dsDTO);
		return "sanpham-single";
	}

	// ====================================================================================================
	@GetMapping("/cart")
	public String showCartPage(HttpServletRequest request, ModelMap modelMap) {
		GioHang gioHang = CartUtils.layGioHang(request);
		double tongTien = gioHang.tinhTongThanhTien();
		modelMap.addAttribute("gioHang", gioHang);
		modelMap.addAttribute("tongTien", tongTien);
		modelMap.addAttribute("thbao", "");
		return "giohang";
	}

	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest request, ModelMap modelMap, @RequestParam("id") int sanpham_id)
			throws SQLException, IOException {

		int maSize = Integer.parseInt(request.getParameter("sizeid"));
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		SanPhamSKUDTO sku = skuService.layTTSku(sanpham_id, maSize);

		GioHang gioHang = CartUtils.layGioHang(request);
		gioHang.themSanPham(sku, soLuong);
		return "redirect:/cart";
	}

	@GetMapping("/deleteFromCart")
	public String deleteFromCart(HttpServletRequest request, ModelMap modelMap, @RequestParam("id") int sku_id) {
		SanPhamSKUDTO sku = skuService.layTTSku(sku_id);
		GioHang gioHang = CartUtils.layGioHang(request);
		gioHang.xoaSanPham(sku);
		return "redirect:/cart";
	}

	@PostMapping("/updateCart")
	public String updateCart(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("gioHang") GioHang gioHangNew) {
		GioHang gioHang = CartUtils.layGioHang(request);
		gioHang.capNhatSoLuong(gioHangNew);
		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String showCheckOutPage(HttpServletRequest request, ModelMap modelMap) {
		String email = request.getUserPrincipal().getName();
		NguoiDung nd = nguoiDungService.layThongTinNguoiDung(email);
		KhachHangDTO khachHang = new KhachHangDTO(nd.getId(), nd.getTenNguoiDung(), nd.getDiaChi(), nd.getSoDienThoai(),
				nd.getEmail());
		GioHang gioHang = CartUtils.layGioHang(request);
		if (!gioHang.getDsCT().isEmpty()) {
			double tongTien = gioHang.tinhTongThanhTien();

			modelMap.addAttribute("khachHang", khachHang);
			modelMap.addAttribute("gioHang", gioHang);
			modelMap.addAttribute("tongTien", tongTien);
			return "thanhtoan";
		}
		modelMap.addAttribute("thbao", "Chưa có sản phẩm nào");
		return "giohang";

	}

	@PostMapping("/saveOrder")
	public String saveOrder(HttpServletRequest request, ModelMap modelMap) throws Exception {
		int kh_id = Integer.parseInt(request.getParameter("kh_id"));
		String tenKhachHang = request.getParameter("tenKhachHang");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");

		KhachHangDTO khachHangDTO = new KhachHangDTO(kh_id, tenKhachHang, diaChi, soDienThoai, email);
		nguoiDungService.capNhatNguoiDung(kh_id, khachHangDTO);

		GioHang gioHang = CartUtils.layGioHang(request);
		gioHang.setKhachHangDTO(khachHangDTO);

		donHangService.luuDonHang(gioHang);
		CartUtils.xoaGioHang(request);

		return "redirect:/orderSuccess";
	}

	@GetMapping("/orderSuccess")
	public String orderSuccessPage() {
		return "orderSuccess";
	}

	@GetMapping("/user")
	public String userPage(HttpServletRequest request, ModelMap modelMap) {
		String email = request.getUserPrincipal().getName();
		NguoiDung nd = nguoiDungService.layThongTinNguoiDung(email);

		List<DonHang> dsDonHang = nd.getDsDonHang();

		modelMap.addAttribute("user", nd);
		modelMap.addAttribute("dsDonHang", dsDonHang);
		modelMap.addAttribute("error", request.getParameter("error"));
		return "nguoidung";
	}

	@GetMapping("order")
	public String ListOrderDetails(HttpServletRequest request, ModelMap model, @RequestParam("id") int orderId) {
		String email = request.getUserPrincipal().getName();
		NguoiDung nd = nguoiDungService.layThongTinNguoiDung(email);
		DonHang dh = donHangService.layThongTinDonHang(orderId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		model.addAttribute("dsCT_DonHang", ctDonHangService.layDSCT_DonHang(orderId));
		model.addAttribute("user", nd);
		model.addAttribute("donHang", dh);
		model.addAttribute("ngayDat", sdf.format(dh.getNgayDat()));
		return "CTDonHang";
	}

	@PostMapping("/updateUser")
	public String updateUser(HttpServletRequest request, ModelMap modelMap) {

		String email = request.getUserPrincipal().getName();
		NguoiDung nd = nguoiDungService.layThongTinNguoiDung(email);

		nd.setDiaChi(request.getParameter("diaChi"));
		nd.setSoDienThoai(request.getParameter("soDienThoai"));
		nd.setTenNguoiDung(request.getParameter("tenKhachHang"));
		String mkMoi = request.getParameter("matKhauMoi");
		String xnMatKhau = request.getParameter("xacNhanMK");
		if (!mkMoi.trim().equals("")||!xnMatKhau.trim().equals("")) {
			if (mkMoi.equals(xnMatKhau)) {
				nd.setMatKhau(passwordEncoder.encode(request.getParameter("matKhauMoi")));
				nguoiDungService.suaNguoiDung(nd, nd.getRole().getId());
			}else {
				modelMap.addAttribute("error", true);
				return "redirect:/user";
			}
		}else {
			nguoiDungService.suaThongTinCobanNguoiDung(nd, nd.getRole().getId());
		}
		modelMap.addAttribute("error", false);
		return "redirect:/user";
	}
}
