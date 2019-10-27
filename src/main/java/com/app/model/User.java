package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.engine.profile.Fetch;

@Entity
@Table(name="usertab")
public class User {
	
	public User() {
		super();
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", password=" + password
				+ ", roles=" + roles + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	@Id
	@GeneratedValue
	private int id;
	
	
	private String userName;
	
	
	private String userEmail;
	
	
	private  String password;
	
	
	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles",
	joinColumns=@JoinColumn(name="uid"))
			
	@Column(name="u_roles")		
	private List<String> roles;
	
	
	
}
