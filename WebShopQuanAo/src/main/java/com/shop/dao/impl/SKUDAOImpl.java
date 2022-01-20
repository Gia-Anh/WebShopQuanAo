package com.shop.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.SKUDAO;
import com.shop.dto.SanPhamDTO;
import com.shop.dto.SanPhamSKUDTO;
import com.shop.entity.SanPham;
import com.shop.entity.SanPhamSKU;
import com.shop.entity.SizeSP;

@Repository
public class SKUDAOImpl implements SKUDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SizeSP> layDsSize() {
		Session session = sessionFactory.getCurrentSession();
		Query<SizeSP> query = session.createQuery("from SizeSP", SizeSP.class);
        List<SizeSP> dssize = query.getResultList();
        return dssize;
	}
	
	@Override
	public void luuSanPhamSKU(SanPhamDTO sanPhamDTO) {
		Session session = sessionFactory.getCurrentSession();
		
		SanPham sp = session.get(SanPham.class, sanPhamDTO.getId());
		
		HashMap<Integer, Integer> sizeMap = sanPhamDTO.getSize();
		for (Integer sizeId : sizeMap.keySet()) {
		      SizeSP size = session.get(SizeSP.class, sizeId);
		      SanPhamSKU sku = new SanPhamSKU(sp, size, sizeMap.get(sizeId));
		      session.saveOrUpdate(sku);
		}	
	}
	
	@Override
	public List<SanPhamSKU> layDsSKU(int sanPhamId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<SanPhamSKU> query = session.createQuery("from SanPhamSKU where sanpham_id=:sanphamId", SanPhamSKU.class);
		query.setParameter("sanphamId", sanPhamId);
		List<SanPhamSKU> dsSku = query.getResultList();
		return dsSku;
	}

	@Override
	public void xoaSKU(int sanPhamId) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from SanPhamSKU where sanpham_id=:sanphamId");
		query.setParameter("sanphamId", sanPhamId);
		query.executeUpdate();
	}

	@Override
	public void capNhatSanPhamSKU(SanPhamDTO sanPhamDTO) {
		Session session = sessionFactory.getCurrentSession();
		
		SanPham sp = session.get(SanPham.class, sanPhamDTO.getId());
		
		Query<SanPhamSKU> query = session.createQuery("from SanPhamSKU where sanpham_id=:sanphamId", SanPhamSKU.class);
		query.setParameter("sanphamId", sanPhamDTO.getId());
		List<SanPhamSKU> dsSku = query.getResultList();
		//Lấy ds size có sẵn
		ArrayList<Integer> listSizeId = new ArrayList<Integer>();
		for (SanPhamSKU sanPhamSKU : dsSku) {
			listSizeId.add(sanPhamSKU.getSizeSP().getId());
		}
		//Mã size + số lượng
		HashMap<Integer, Integer> sizeMap = sanPhamDTO.getSize();
		
		for (Integer sizeId : sizeMap.keySet()) {
			if (listSizeId.contains(sizeId)) {
				SizeSP size = session.get(SizeSP.class, sizeId);
				Query<SanPhamSKU> query2 = session.createQuery("from SanPhamSKU where sanpham_id=:sanphamId and size_id=:sizeId", SanPhamSKU.class);
				query2.setParameter("sanphamId", sp.getId());
				query2.setParameter("sizeId", sizeId);
				SanPhamSKU sanPhamSKU = query2.getSingleResult();
//				sanPhamSKU.setSanPham(sp);
//				sanPhamSKU.setSizeSP(size);
				sanPhamSKU.setSoLuongTon(sizeMap.get(sizeId));
				session.saveOrUpdate(sanPhamSKU);
			}else {
				SizeSP size = session.get(SizeSP.class, sizeId);
				SanPhamSKU sanPhamSKU = new SanPhamSKU(sp, size, sizeMap.get(sizeId));
				session.saveOrUpdate(sanPhamSKU);
			}
		}
	}

	@Override
	public int getSKUId(int sanpham_id, int size_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from SanPhamSKU where sanpham_id=:sanphamId and size_id=:sizeId");
		query.setParameter("sanphamId", sanpham_id);
		query.setParameter("sizeId", size_id);
		SanPhamSKU sku = (SanPhamSKU) query.getSingleResult();
		return sku.getId();
	}

	@Override
	public SanPhamSKUDTO layTTSku(int sanpham_id, int size_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from SanPhamSKU where sanpham_id=:sanphamId and size_id=:sizeId");
		query.setParameter("sanphamId", sanpham_id);
		query.setParameter("sizeId", size_id);
		SanPhamSKU sku = (SanPhamSKU) query.getSingleResult();
		
		SanPhamSKUDTO dto = new SanPhamSKUDTO();
		dto.setSku_id(sku.getId());
		dto.setTenSanPham(sku.getSanPham().getTenSanPham());
		dto.setGia(sku.getSanPham().getGia());
		dto.setSize(sku.getSizeSP().getTenSize());
		
		Blob blob = sku.getSanPham().getHinhAnh();
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
				dto.setBase64Image(base64Image);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public SanPhamSKU getSanPhamSKU(int sku_id) {
		Session session = sessionFactory.getCurrentSession();
		SanPhamSKU sku = session.get(SanPhamSKU.class, sku_id);
		return sku;
	}

	@Override
	public SanPhamSKUDTO layTTSku(int sku_id) {
		Session session = sessionFactory.getCurrentSession();
		SanPhamSKU sku = session.get(SanPhamSKU.class, sku_id);
		
		SanPhamSKUDTO dto = new SanPhamSKUDTO();
		dto.setSku_id(sku.getId());
		dto.setTenSanPham(sku.getSanPham().getTenSanPham());
		dto.setGia(sku.getSanPham().getGia());
		dto.setSize(sku.getSizeSP().getTenSize());
		
		Blob blob = sku.getSanPham().getHinhAnh();
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
				dto.setBase64Image(base64Image);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

	
}
