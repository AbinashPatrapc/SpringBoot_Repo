package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService service;

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
	@PostMapping("/register")
	public String addEmployee(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
		String result=service.addEmployee(emp);
		List<Employee> list=service.getAllEmployee();
		map.put("resultMsg",result);
		map.put("List", list);
		return "employee_report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no")int no,Map<String,Object>map) {
		String msg=service.deleteEmployee(no);
		List<Employee> list=service.getAllEmployee();
		map.put("resultMsg", msg);
		map.put("List", list);
		return "employee_report";
	}
	
	@GetMapping("/edit")
	public String showEmployeeEditForm(@RequestParam("no")int no,@ModelAttribute("emp") Employee emp) {
		Employee emp1=service.getEmployeeByNo(no);
		//emp=emp1;
		//or
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit";
	}
	
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object>map) {
		String msg=service.editEmployee(emp);
		List<Employee> list=service.getAllEmployee();
		map.put("resultMsg", msg);
		map.put("List", list);
		
		return "employee_report";
	}
	
	
}
