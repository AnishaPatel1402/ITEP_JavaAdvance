package com.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping({"/"})	
	  public String getHomePage() {
		  return "home";
	  }
	 
	 @GetMapping("/create-new-account")
	 public String getSignUpPage() {
		 return "create-account";
	 }
}
