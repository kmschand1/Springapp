package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
public class UserController {
	
	
	@Autowired
	private IUserService service;
	
	@RequestMapping("/reg")
	  public String showReg(){
		  
		  
		  
		  return"registrationPage";
	  }

	
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	  public String showReg(@ModelAttribute User user,ModelMap map ){
		   int id=service.saveUser(user);
		   String msg="user saved with id=="+id;
		             map.addAttribute("id", id);
		  
		  return"registrationPage";
	  }
	
	
}
