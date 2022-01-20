package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.RoleDAO;
import com.shop.entity.DonHang;
import com.shop.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Role> layDsRole() {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("FROM Role", Role.class);
		List<Role> dsRole = query.getResultList();
		return dsRole;
	}
	@Override
	public Role layThongTinRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, id);
	}

}
