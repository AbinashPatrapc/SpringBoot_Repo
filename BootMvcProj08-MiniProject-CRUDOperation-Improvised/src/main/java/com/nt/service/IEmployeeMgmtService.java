package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> getAllEmployee();
	public String addEmployee(Employee emp);
	public String deleteEmployee(int eid);
	public String editEmployee(Employee emp);
	public Employee getEmployeeByNo(int no);
}
