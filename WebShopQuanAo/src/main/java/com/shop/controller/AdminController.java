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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.shop.dto.SanPhamDTO;
import com.shop.entity.CT_DonHang;
import com.shop.entity.DonHang;
import com.shop.entity.LoaiSanPham;
import com.shop.entity.NguoiDung;
import com.shop.entity.NhaCungCap;
import com.shop.entity.Role;
import com.shop.entity.SanPham;
import com.shop.entity.SanPhamSKU;
import com.shop.entity.SizeSP;
import com.shop.service.CT_DonHangService;
import com.shop.service.DonHangService;
import com.shop.service.LoaiSanPhamService;
import com.shop.service.NguoiDungService;
import com.shop.service.NhaCungCapService;
import com.shop.service.RoleService;
import com.shop.service.SKUService;
import com.shop.service.SanPhamService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private LoaiSanPhamService loaiSPService;
	@Autowired
	private NhaCungCapService nhaCCService;
	@Autowired
	private SKUService skuService;
	@Autowired
	NguoiDungService nguoiDungService;
	@Autowired
	DonHangService donHangService;
	@Autowired
	CT_DonHangService ctDonHangService;
	@Autowired
	RoleService roleService;
	
	@GetMapping("")
	public String showAdminPage() {
		return "Admin-page";
	}

	@GetMapping("/product")
	public String listSanPham(ModelMap modelMap) throws SQLException, IOException {
		List<SanPham> dssp = sanPhamService.layDsSanPham();
		List<SanPhamDTO> dsDTO = new ArrayList<SanPhamDTO>();
		for (SanPham sanPham : dssp) {
			SanPhamDTO dto = sanPhamService.layTTSanPham(sanPham.getId());
			dto.setSoLuong(sanPham.getTongSoLuong());
			dsDTO.add(dto);
		}
		modelMap.addAttribute("dssp", dsDTO);
		return "Admin-sanPham";
	}

	@GetMapping("/product/add")
	public String showAddForm(ModelMap modelMap) {
		SanPham sanPham = new SanPham();
		List<LoaiSanPham> dsLoaiSP = loaiSPService.layDsLoaiSP();
		List<NhaCungCap> dsNhaCC = nhaCCService.layDsNhaCungCap();
		List<SizeSP> dsSize = skuService.layDsSize();
		HashMap<String, Integer> size = new HashMap<String, Integer>();
		for (SizeSP sizeSP : dsSize) {
//			System.out.println(sizeSP.getTenSize());
			size.put(sizeSP.getTenSize(), null);
		}
		modelMap.addAttribute("sanPham", sanPham);
		modelMap.addAttribute("isUpdate", false);
		modelMap.addAttribute("dsLoaiSP", dsLoaiSP);
		modelMap.addAttribute("dsNhaCC", dsNhaCC);
		modelMap.addAttribute("dsSize", size);
		return "Admin-formSanPham";
	}

	@GetMapping("/product/edit")
	public String showUpdateForm(ModelMap modelMap, @RequestParam("id") int sanpham_id) {
		SanPham sanPham = sanPhamService.layThongTinSP(sanpham_id);
		List<LoaiSanPham> dsLoaiSP = loaiSPService.layDsLoaiSP();
		List<NhaCungCap> dsNhaCC = nhaCCService.layDsNhaCungCap();
		HashMap<String, Integer> size = new HashMap<String, Integer>();
		HashMap<String, Integer> skuMap = new HashMap<String, Integer>();
		List<SanPhamSKU> dsSku = skuService.layDsSKU(sanpham_id);
		for (SanPhamSKU sanPhamSKU : dsSku) {
			skuMap.put(sanPhamSKU.getSizeSP().getTenSize(), sanPhamSKU.getSoLuongTon());
		}
		List<SizeSP> dsSize = skuService.layDsSize();
		for (SizeSP sizeSP : dsSize) {
			if (skuMap.containsKey(sizeSP.getTenSize())) {
				size.put(sizeSP.getTenSize(), skuMap.get(sizeSP.getTenSize()));
			} else {
				size.put(sizeSP.getTenSize(), null);
			}
		}
		modelMap.addAttribute("sanPham", sanPham);
		modelMap.addAttribute("isUpdate", true);
		modelMap.addAttribute("dsLoaiSP", dsLoaiSP);
		modelMap.addAttribute("dsNhaCC", dsNhaCC);
		modelMap.addAttribute("dsSize", size);
		return "Admin-formSanPham";
	}

	@GetMapping("/product/delete")
	public String xoaSanPham(@RequestParam("id") int sanpham_id) {
		sanPhamService.xoaSanPham(sanpham_id);
		return "redirect:/admin/product";
	}

	@PostMapping("/product/save")
	public String saveProduct(HttpServletRequest request, @RequestParam("image") MultipartFile image)
			throws IOException, ServletException {
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		String tenSanPham = request.getParameter("tenSanPham");
		String moTa = request.getParameter("moTa");
		double gia = Double.parseDouble(request.getParameter("gia"));
		int loaisp_id = Integer.parseInt(request.getParameter("loaiSanPham"));
		int nhacc_id = Integer.parseInt(request.getParameter("nhaCungCap"));
		sanPhamDTO.setTenSanPham(tenSanPham);
		sanPhamDTO.setMoTa(moTa);
		sanPhamDTO.setGia(gia);
		sanPhamDTO.setLoaiSanPham(loaisp_id);
		sanPhamDTO.setNhaCungCap(nhacc_id);
		List<SizeSP> dsSize = skuService.layDsSize();
		HashMap<Integer, Integer> size = new HashMap<Integer, Integer>();
		for (SizeSP sizeSP : dsSize) {
			String checked = request.getParameter(sizeSP.getTenSize());
			if (checked != null) {
				int soLuong = Integer.parseInt(request.getParameter("soLuong" + sizeSP.getTenSize() + ""));
				size.put(sizeSP.getId(), soLuong);
			}
		}
		sanPhamDTO.setSize(size);
		sanPhamDTO.setUpdate(false);
		InputStream inputStream = null;
		if (image != null) {
			inputStream = image.getInputStream();
		}
		int id = sanPhamService.luuSanPham(sanPhamDTO, inputStream);
		sanPhamDTO.setId(id);
		skuService.luuSanPhamSKU(sanPhamDTO);
		return "redirect:/admin/product";
	}

	@PostMapping("/product/update")
	public String updateProduct(HttpServletRequest request, @RequestParam("image") MultipartFile image)
			throws IOException {
		SanPhamDTO sanPhamDTO = new SanPhamDTO();
		int id = Integer.parseInt(request.getParameter("id"));
		String tenSanPham = request.getParameter("tenSanPham");
		String moTa = request.getParameter("moTa");
		double gia = Double.parseDouble(request.getParameter("gia"));
		int loaisp_id = Integer.parseInt(request.getParameter("loaiSanPham"));
		int nhacc_id = Integer.parseInt(request.getParameter("nhaCungCap"));
		sanPhamDTO.setUpdate(true);
		sanPhamDTO.setId(id);
		sanPhamDTO.setTenSanPham(tenSanPham);
		sanPhamDTO.setMoTa(moTa);
		sanPhamDTO.setGia(gia);
		sanPhamDTO.setLoaiSanPham(loaisp_id);
		sanPhamDTO.setNhaCungCap(nhacc_id);
		List<SizeSP> dsSize = skuService.layDsSize();
		HashMap<Integer, Integer> size = new HashMap<Integer, Integer>();
		for (SizeSP sizeSP : dsSize) {
			String checked = request.getParameter(sizeSP.getTenSize());
			if (checked != null) {
				int soLuong = Integer.parseInt(request.getParameter("soLuong" + sizeSP.getTenSize() + ""));
				size.put(sizeSP.getId(), soLuong);
			}
		}
		sanPhamDTO.setSize(size);
		sanPhamDTO.setUpdate(true);
		InputStream inputStream = null;
		if (image != null) {
			inputStream = image.getInputStream();
		}
		int spid = sanPhamService.luuSanPham(sanPhamDTO, inputStream);
		skuService.capNhatSanPhamSKU(sanPhamDTO);
		return "redirect:/admin/product";
	}
	
	@GetMapping("/product/view")
	public String viewProduct(@RequestParam("id")int product_id, ModelMap modelMap) throws SQLException, IOException {
		SanPhamDTO sanPhamDTO = sanPhamService.layTTSanPham(product_id);
		//Tên size + số lượng tồn
		HashMap<String, Integer> skuMap = new HashMap<String, Integer>();
		List<SanPhamSKU> dsSku = skuService.layDsSKU(product_id);
		NhaCungCap ncc = nhaCCService.layThongTinNCC(sanPhamDTO.getNhaCungCap());
		LoaiSanPham lsp = loaiSPService.layThongTinLoaiSP(sanPhamDTO.getLoaiSanPham());

		for (SanPhamSKU sanPhamSKU : dsSku) {
			skuMap.put(sanPhamSKU.getSizeSP().getTenSize(), sanPhamSKU.getSoLuongTon());
		}

		SanPham sp = sanPhamService.layThongTinSP(product_id);

		modelMap.addAttribute("sanPham", sanPhamDTO);
		modelMap.addAttribute("dsSize", skuMap);
		modelMap.addAttribute("nhaCungCap", ncc.getTenNCC());
		modelMap.addAttribute("loaiSP", lsp.getTenLoaiSP());
		
		return "Admin-sanpham-single";
	}

	@GetMapping("/supplier")
	public String ListSupplier(ModelMap model) {
		model.addAttribute("dsNcc", nhaCCService.layDsNhaCungCap());
		return "Admin-nhaCungCap";
	}

	@GetMapping("/supplier/add")
	public String showFormAddSupplier(ModelMap model) {
		NhaCungCap ncc = new NhaCungCap();
		model.addAttribute("nhaCungCap", ncc);
		model.addAttribute("isUpdate", false);
		return "Admin-formNhaCungCap";
	}

	@GetMapping("/supplier/update")
	public String showFormUpdateSupplier(ModelMap model, @RequestParam("id") int id) {
		NhaCungCap ncc = nhaCCService.layThongTinNCC(id);
		model.addAttribute("nhaCungCap", ncc);
		model.addAttribute("isUpdate", true);
		return "Admin-formNhaCungCap";
	}

	@PostMapping("/supplier/save")
	public String saveSupplier(@ModelAttribute("nhaCungCap") NhaCungCap ncc) {
		List<SanPham> sanPhams = null;
		if (ncc.getId() != 0) {
			sanPhams = nhaCCService.layDsSanPham(ncc.getId());
		}
		ncc.setDssp(sanPhams);
		nhaCCService.luuNhaCungCap(ncc);
		return "redirect:/admin/supplier";
	}

	@GetMapping("/supplier/delete")
	public String deleteSupplier(ModelMap model, @RequestParam("id") int id) {
		nhaCCService.xoaNhaCungCap(id);
		return "redirect:/admin/supplier";
	}

	@GetMapping("order")
	public String ListOrder(ModelMap model) {
		model.addAttribute("dsDonHang", donHangService.layDsDonHang());
		return "Admin-DonHang";
	}

	@GetMapping("/order/view")
	public String ListOrderDetails(ModelMap model, @RequestParam("id") int id) {
		
		DonHang dh = donHangService.layThongTinDonHang(id);
		NguoiDung nd = nguoiDungService.layThongTinNguoiDung(dh.getNguoiDung().getId());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		model.addAttribute("user", nd);
		model.addAttribute("donHang", dh);
		model.addAttribute("ngayDat", sdf.format(dh.getNgayDat()));
		model.addAttribute("dsCT_DonHang", ctDonHangService.layDSCT_DonHang(id));
		return "CTDonHang";
	}

	@GetMapping("user")
	public String ListUser(ModelMap model) {
		model.addAttribute("dsNguoiDung", nguoiDungService.layDsNguoiDung());
		model.addAttribute("thbao", "");
		return "Admin-NguoiDung";
	}

	@GetMapping("/user/add")
	public String showFormAddUser(ModelMap model) {
		NguoiDung nguoiDung = new NguoiDung();
		model.addAttribute("nguoiDung", nguoiDung);
		model.addAttribute("dsRole", roleService.layDsRole());
		model.addAttribute("isUpdate", false);
		return "Admin-formNguoiDung";
	}

	@GetMapping("/user/update")
	public String showFormUpdateUser(ModelMap model, @RequestParam("id") int id) {
		NguoiDung nguoiDung = nguoiDungService.layThongTinNguoiDung(id);
		model.addAttribute("nguoiDung", nguoiDung);
		model.addAttribute("dsRole", roleService.layDsRole());
		model.addAttribute("isUpdate", true);
		return "Admin-formNguoiDung";
	}

	@PostMapping("/user/save")
	public String saveUser(@ModelAttribute("nguoiDung") NguoiDung nguoiDung, @RequestParam("role") String roleId,
			ModelMap model) {
		List<DonHang> donHangs = null;
		if (nguoiDung.getId() == 0) {
			if (!nguoiDungService.checkEmail(nguoiDung.getEmail())) {
				nguoiDungService.themNguoiDung(nguoiDung, Integer.parseInt(roleId));
				return "redirect:/admin/user";
			} else {
				Role role = roleService.layThongTinRole(Integer.parseInt(roleId));
				nguoiDung.setRole(role);
				model.addAttribute("dsRole", roleService.layDsRole());
				model.addAttribute("thbao", "Email đã tồn tại");
				return "Admin-formNguoiDung";
			}
		}
		NguoiDung ndTemp = nguoiDungService.layThongTinNguoiDung(nguoiDung.getId());
		donHangs = ndTemp.getDsDonHang();
		nguoiDung.setDsDonHang(donHangs);
		nguoiDung.setMatKhau(ndTemp.getMatKhau());
		nguoiDungService.suaNguoiDung(nguoiDung, Integer.parseInt(roleId));

		return "redirect:/admin/user";
	}

	@GetMapping("/user/delete")
	public String deleteUser(ModelMap model, @RequestParam("id") int id) {
		nguoiDungService.xoaNguoiDung(id);
		return "redirect:/admin/user";
	}
}