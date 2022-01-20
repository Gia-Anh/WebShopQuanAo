package com.shop.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.NguoiDungDAO;
import com.shop.entity.NguoiDung;

@Service
public class MyDBAuthenticationService implements UserDetailsService{

	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		NguoiDung nguoiDung = nguoiDungDAO.layThongTinNguoiDung(email);
		
		if (nguoiDung == null) {
			throw new UsernameNotFoundException("Email " + email + " không tồn tại!");
		}
		
		String role = nguoiDung.getRole().getTenRole();
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		//ROLE_ADMIN, ROLE_USER
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		grantList.add(authority);
 
        UserDetails userDetails = (UserDetails) new User(nguoiDung.getEmail(), nguoiDung.getMatKhau(),grantList);
 
        return userDetails;
	}

}
