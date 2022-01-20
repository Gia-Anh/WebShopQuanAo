package com.shop.dao;

import java.util.List;

import com.shop.entity.Role;

public interface RoleDAO {
	public List<Role> layDsRole();

	public Role layThongTinRole(int id);
}
