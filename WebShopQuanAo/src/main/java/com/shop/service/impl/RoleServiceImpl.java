package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.RoleDAO;
import com.shop.entity.Role;
import com.shop.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO roleDao;
	@Override
	public List<Role> layDsRole() {
		return roleDao.layDsRole();
	}
	@Override
	public Role layThongTinRole(int id) {
		return roleDao.layThongTinRole(id);
	}

}
