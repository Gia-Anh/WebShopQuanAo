package com.shop.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.SanPhamDAO;
import com.shop.dto.SanPhamDTO;
import com.shop.entity.LoaiSanPham;
import com.shop.entity.NhaCungCap;
import com.shop.entity.SanPham;
import com.shop.entity.SanPhamSKU;
import com.shop.util.SortUtils;

@Repository
public class SanPhamDAOImpl implements SanPhamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SanPham layThongTinSP(int id) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sp = session.get(SanPham.class, id);
		return sp;
	}

	@Override
	public List<SanPham> layDsSanPham() {
		Session session = sessionFactory.getCurrentSession();
		Query<SanPham> query = session.createQuery("from SanPham", SanPham.class);
		List<SanPham> dssp = query.getResultList();
		return dssp;
	}

	//Trả về id khi thêm thành công
	@Override
	public int luuSanPham(SanPhamDTO sanPhamDTO, InputStream inputStream) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sp = null;
		if (sanPhamDTO.isUpdate()==false) {
			sp = new SanPham();
		}else {
			sp = session.find(SanPham.class, sanPhamDTO.getId());
		}
		
		LoaiSanPham loaiSanPham = session.get(LoaiSanPham.class, sanPhamDTO.getLoaiSanPham());
		NhaCungCap nhaCungCap = session.get(NhaCungCap.class, sanPhamDTO.getNhaCungCap());

		sp.setTenSanPham(sanPhamDTO.getTenSanPham());
		sp.setMoTa(sanPhamDTO.getMoTa());
		sp.setGia(sanPhamDTO.getGia());
		sp.setLoaiSanPham(loaiSanPham);
		sp.setNhaCungCap(nhaCungCap);
		
		try {
			if (inputStream != null) {
				byte[] bytes = IOUtils.toByteArray(inputStream);
				Blob image = Hibernate.getLobCreator(session).createBlob(bytes);
				sp.setHinhAnh(image);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		session.saveOrUpdate(sp);
		return sp.getId();
	}

	@Override
	public void xoaSanPham(int id) {
		Session session = sessionFactory.getCurrentSession();

		//Xóa các sku liên quan
		Query query = session.createQuery("delete from SanPhamSKU where sanpham_id=:sanphamId");
		query.setParameter("sanphamId", id);
		query.executeUpdate();
		
		//Xóa sản phẩm
		Query query2 = session.createQuery("delete from SanPham where id=:sanphamId");
		query2.setParameter("sanphamId", id);
		query2.executeUpdate();
		
	}

	@Override
	public SanPhamDTO layTTSanPham(int sanPhamId) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = null;
		SanPhamDTO sanPhamDTO = new SanPhamDTO();

		sanPham = session.get(SanPham.class, sanPhamId);
		sanPhamDTO.setId(sanPhamId);
		sanPhamDTO.setTenSanPham(sanPham.getTenSanPham());
		sanPhamDTO.setMoTa(sanPham.getMoTa());
		sanPhamDTO.setGia(sanPham.getGia());
		sanPhamDTO.setNhaCungCap(sanPham.getNhaCungCap().getId());
		sanPhamDTO.setLoaiSanPham(sanPham.getLoaiSanPham().getId());
		Blob blob = sanPham.getHinhAnh();

		try {
			if (blob != null) {
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				sanPhamDTO.setBase64Image(base64Image);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return sanPhamDTO;
	}

	@Override
	public List<SanPham> timKiemSanPham(String tenSanPham, int page) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> dssp = null;
		Query<SanPham> query = null;
		if (tenSanPham != null && tenSanPham.trim().length() > 0) {
			query = session.createQuery("from SanPham where lower(tenSanPham) like :tenSP", SanPham.class);
			query.setParameter("tenSP", "%" + tenSanPham.toLowerCase() + "%");
		}else {
			query = session.createQuery("from SanPham", SanPham.class);
		}
		if (page==0) {
			page = 1;
		}
		int skip = (page-1) * 9;
		dssp = query.setFirstResult(skip).setMaxResults(9).getResultList();
		return dssp;
	}

	@Override
	public List<SanPham> locSanPham(int sortId) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> dssp = null;
		Query<SanPham> query = null;
		switch (sortId) {
			case 0:
				query = session.createQuery("from SanPham", SanPham.class);
				break;
			case SortUtils.TEN_ASC:
				query = session.createQuery("from SanPham order by tenSanPham", SanPham.class);
				break;
			case SortUtils.TEN_DESC:
				query = session.createQuery("from SanPham order by tenSanPham desc", SanPham.class);
				break;
			case SortUtils.GIA_ASC:
				query = session.createQuery("from SanPham order by gia", SanPham.class);
				break;
			case SortUtils.GIA_DESC:
				query = session.createQuery("from SanPham order by gia desc", SanPham.class);
				break;
		}
		dssp = query.getResultList();
		return dssp;
	}

	@Override
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP, int page) {
		Session session = sessionFactory.getCurrentSession();
		Query<SanPham> query = session.createQuery("from SanPham where loaisp_id = :loaiSpId", SanPham.class);
		query.setParameter("loaiSpId", loaiSP);
		if (page==0) {
			page = 1;
		}
		int skip = (page-1) * 9;
		List<SanPham> dssp = query.setFirstResult(skip).setMaxResults(9).getResultList();
		return dssp;
	}
	
	@Override
	public List<SanPham> layDsSanPhamTheoLoai(int loaiSP) {
		Session session = sessionFactory.getCurrentSession();
		Query<SanPham> query = session.createQuery("from SanPham where loaisp_id = :loaiSpId", SanPham.class);
		query.setParameter("loaiSpId", loaiSP);
		List<SanPham> dssp = query.getResultList();
		return dssp;
	}

	//1 trang load 9 sản phẩm
	@Override
	public List<SanPham> layDsSanPhamTheoTrang(int page) {
		Session session = sessionFactory.getCurrentSession();
		if (page==0) {
			page = 1;
		}
		int skip = (page-1) * 9;
		
		List<SanPham> dssp = session.createQuery("from SanPham order by id desc", SanPham.class).setFirstResult(skip).setMaxResults(9).getResultList();
		return dssp;
	}

	@Override
	public long getTotalPage() {
		Session session = sessionFactory.getCurrentSession();
		long totalProduct = (long) session.createQuery("select count(sp) from SanPham sp").getSingleResult();
		long totalPage;
		if (totalProduct%9 != 0) {
			totalPage = totalProduct/9 + 1;
		}else {
			totalPage = totalProduct/9;
		}		 
		return totalPage;
	}
	
	@Override
	public long getTotalPage2(int loaispID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(sp) from SanPham sp where loaiSanPham.id=:loaispID");
		query.setParameter("loaispID", loaispID);
		long totalProduct = (long) query.getSingleResult();
		long totalPage;
		if (totalProduct%9 != 0) {
			totalPage = totalProduct/9 + 1;
		}else {
			totalPage = totalProduct/9;
		}		 
		return totalPage;
	}


	@Override
	public List<SanPham> searchAndSort(String tenSanPham, int sortType, int page) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> dssp = null;
		Query<SanPham> query = null;
		String sql = "from SanPham";
		if (tenSanPham != null && tenSanPham.trim().length() > 0) {
			sql += " where lower(tenSanPham) like '%"+ tenSanPham.toLowerCase() + "%'";
		}
		switch (sortType) {
			case 0:
				sql += "";
				break;
			case SortUtils.TEN_ASC:
				sql += " order by tenSanPham";
				break;
			case SortUtils.TEN_DESC:
				sql += " order by tenSanPham desc";
				break;
			case SortUtils.GIA_ASC:
				sql += " order by gia";
				break;
			case SortUtils.GIA_DESC:
				sql += " order by gia desc";
				break;
		}
		if (page==0) {
			page = 1;
		}
		int skip = (page-1) * 9;
		query = session.createQuery(sql, SanPham.class).setFirstResult(skip).setMaxResults(9);
		dssp = query.getResultList();
		return dssp;
	}

	@Override
	public long getTotalSearchPage(String tenSanPham) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(sp) from SanPham sp where lower(tenSanPham) like :tenSP");
		query.setParameter("tenSP", "%" + tenSanPham.toLowerCase() + "%");
		long maxResult = (long) query.getSingleResult();
		long maxPage;
		if (maxResult%9 != 0) {
			maxPage = maxResult/9 + 1;
		}else {
			maxPage = maxResult/9;
		}	
		return maxPage;
	}

	
}
