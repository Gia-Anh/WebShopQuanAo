package com.shop.service;

import java.util.List;

import com.shop.entity.Role;

public interface RoleService {
	public List<Role> layDsRole();
	public Role layThongTinRole(int id);
}
