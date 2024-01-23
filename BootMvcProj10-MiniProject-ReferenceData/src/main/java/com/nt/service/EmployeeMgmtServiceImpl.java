package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo emprepo;
	@Autowired
	private Environment env;

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
		Locale[] locale=Locale.getAvailableLocales();
		Set<String>countryList=new TreeSet();
		for(Locale l:locale) {
			if(l!=null) 
				countryList.add(l.getDisplayCountry());
		}
		return countryList;
	}

	@Override
	public List<String> getStatesByCountry(String country) {
		String statesinfo=env.getRequiredProperty(country);
		List<String> stateList=Arrays.asList(statesinfo.split(","));
		return stateList;
	}

	

}
