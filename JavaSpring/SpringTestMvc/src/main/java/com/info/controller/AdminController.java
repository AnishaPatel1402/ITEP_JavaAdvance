package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.entity.Admin;
import com.info.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping("/signup")
	public String signUpAction(@ModelAttribute Admin admin) {
		admin = service.registerAdmin(admin);
		if(admin != null) return "home";
		return "create-account";
	}
	
	@PostMapping("/signin")
	public String signINAction(@ModelAttribute Admin admin, HttpSession session) {
		admin = service.loginAdmin(admin);
		if(admin!=null) {
			session.setAttribute("isLoggedIn", true);
			session.setAttribute("currAdmin", admin.getEmail());
			return "redirect:/dashboard";
		}
			
		return "redirect:/home";
	}
}
