package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validations.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map, Employee emp) {
		List<Employee> list = service.getAllEmployee();
		map.put("List", list);
		return "employee_report";
	}

	@GetMapping("/register")
	public String registerEmployee(@ModelAttribute("emp") Employee emp) {
		emp.setJob("Clerk");
		return "addEmp";
	}

	// By using Redirect Attribute we can show the success meg only once
	// on the second refresh the message vanishes
	// @PostMapping("/register")
//	public String addEmployee(RedirectAttributes attr,@ModelAttribute("emp") Employee emp) {
//		String result=service.addEmployee(emp);
//		attr.addFlashAttribute("resultMsg",result);
//		return "redirect:report";
//	}

	// If we use HttpSession obj to set Attribute the Success msg remain
	// constant irrespective of as many refresh we do.
	@PostMapping("/register")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if (errors.hasFieldErrors()) {
			return "employee_report";
		}
		if (empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if (errors.hasErrors())
				return "employee_report";
		}

		if (emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
		}
		String result = service.addEmployee(emp);
		ses.setAttribute("resultMsg", result);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, RedirectAttributes attr) {
		String msg = service.deleteEmployee(no);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String showEmployeeEditForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = service.getEmployeeByNo(no);
		// emp=emp1;
		// or
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit";
	}

	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attr, BindingResult errors) {
		if (errors.hasFieldErrors()) {
			return "employee_report";
		}
		if (empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if (errors.hasErrors())
				return "employee_report";
		}
		if (emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
		}
		String msg = service.editEmployee(emp);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

}
