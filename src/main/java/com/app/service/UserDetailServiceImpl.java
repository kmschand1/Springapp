package com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	private IUserDao dao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		
		
	com.app.model.User u=	dao.loadUserByUserEmail(email);
		
		Set<GrantedAuthority> auths= new HashSet<>();
		
		for(String auth:u.getRoles()){
			
			auths.add(new SimpleGrantedAuthority(auth));
			
		}
		
		
		return new User(email, u.getPassword(), auths);
	}

}
