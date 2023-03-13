package com.mysite.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

	@GetMapping("/")		
	public String index() {
		
		return "index";	
	}
	
	@GetMapping("/sub1")
	public String sub1(){
		
		return "sub1";
	}
	
	@GetMapping("/sub2")
	public String sub2() {
		
		return "sub2";
	}
	

	
	
}
