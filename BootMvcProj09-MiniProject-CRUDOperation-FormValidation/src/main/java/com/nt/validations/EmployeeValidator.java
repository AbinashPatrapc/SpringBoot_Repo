package com.nt.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp=(Employee)target;
	  //Ename validation rule
		if(emp.getEname()==null||emp.getEname().length()==0||emp.getEname().equals("")) {
			errors.rejectValue("ename", "empname.required");
		}else if(emp.getEname().length()>10) {
			errors.rejectValue("ename", "empname.maxlength");
		}
		//Job Validation rule
		if(emp.getJob()==null||emp.getJob().length()==0||emp.getJob().equals("")) {
			errors.rejectValue("job", "empdesg.required");
		}else if(emp.getJob().length()>9) {
			errors.rejectValue("job", "empdesg.maxlength");
		}
		//Salary validation rule
		if(emp.getSal()==null) {
			errors.rejectValue("sal", "empsal.required");
		}else if(emp.getSal()<1||emp.getSal()>10000000){
			errors.rejectValue("sal", "empsal.range");
			
		}

	}

}
