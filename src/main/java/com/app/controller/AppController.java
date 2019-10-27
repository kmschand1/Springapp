package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	
	
	@RequestMapping("/all")
	public String all(){
		
		
		
		return"AllPage";
		
		
	}
	@RequestMapping("/student")
	public String student(){
		
		
		
		return"Student";
		
		
	}
	@RequestMapping("/admin")
	public String admin(){
		
		
		
		return"AdminPage";
		
		
	}
	@RequestMapping("/emp")
	public String emp(){
		
		
		
		return"EmployeePage";
		
		
	}
	@RequestMapping("/home")
	public String home(){
		
		
		
		return"home";
		
		
	}
	@RequestMapping("/common")
	public String common(){
		
		
		
		return"CommonPage";
		
		
	}
	@RequestMapping("/denide")
	public String denide(){
		
		
		
		return"DeniedPage";
		
		
	}
	@RequestMapping("/logout")
	public String logout(){
		
		
		
		return"home";
		
		
	}

}
