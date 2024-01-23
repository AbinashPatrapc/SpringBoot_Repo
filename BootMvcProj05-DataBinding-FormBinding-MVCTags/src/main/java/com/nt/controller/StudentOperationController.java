package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationController {

	@GetMapping("/")
	public String homePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String studentFormPage(@ModelAttribute("stud")Student st) {
		st.setSid(102);
		st.setSaddrs("Banglore");
		return "student_register";
	}
	@PostMapping("/register")
	public String registerStudent(Map<String,Object>map,@ModelAttribute()Student st) {
		return "show_result";
	}
}
