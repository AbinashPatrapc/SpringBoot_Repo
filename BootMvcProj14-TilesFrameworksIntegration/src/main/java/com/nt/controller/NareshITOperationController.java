package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NareshITOperationController {

	@GetMapping("/")
	public String showHomePage() {
		return "homePageDef";
	}
	
	
}
