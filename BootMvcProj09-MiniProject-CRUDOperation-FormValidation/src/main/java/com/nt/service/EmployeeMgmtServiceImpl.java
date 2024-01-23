package com.nt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo emprepo;

	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		int val=emprepo.save(emp).getEmpno();
		return "Employee Registered With "+val+" empNo";
	}

	@Override
	public String deleteEmployee(int eid) {
		emprepo.deleteById(eid);
		return eid+" EmployeeNo Has been Deleted Successfully";
	}

	@Override
	public String editEmployee(Employee emp) {
		int val=emprepo.save(emp).getEmpno();
		return val+" EmpNo Employee is Updated";
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp=emprepo.findById(no).get();
		return emp;
	}

	@Override
	public Set<String> getAllCountry() {
		
		return null;
	}

	

}
