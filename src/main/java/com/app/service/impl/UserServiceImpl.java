package com.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	@Autowired
	 private BCryptPasswordEncoder enc;
	@Transactional
	public int saveUser(User user) {
		
		String  s=user.getPassword();
		System.out.println(s);
		user.setPassword(enc.encode(s));
		System.out.println(s);

		return dao.saveUser(user);
		
	}

	

}
