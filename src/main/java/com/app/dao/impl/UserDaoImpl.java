package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {

	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(user);
	}
	
	@Override
	public User loadUserByUserEmail(String email) {

		String hql="select u from com.app.model.User u where u.userEmail=?0";
		User u1=null;
		  List<User> u= (List<User>) ht.find(hql, email);
		
		  if(u!=null &&!u.isEmpty()){
			  
			  u1= u.get(0);
			  
			  
		  }
		  
		  
		return u1;
	}
}
