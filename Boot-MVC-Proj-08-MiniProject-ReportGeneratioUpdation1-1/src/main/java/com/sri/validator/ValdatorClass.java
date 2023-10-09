package com.sri.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sri.entity.Employee;

@Component
public class ValdatorClass implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		// return clazz==Employee.class;
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee emp = (Employee) target;
		
		if (emp.getEname() == null || emp.getEname().length() == 0)
			errors.rejectValue("ename", "e.ename.required");
		else if (emp.getEname().length() < 5)
			errors.rejectValue("ename", "e.ename.minlength");

		//for Salary Field
		if (emp.getSal() == null)
			errors.rejectValue("sal", "e.sal.required");
		else if(emp.getSal()<1000 || emp.getSal()>100000)
			errors.rejectValue("sal", "e.sal.range");
		else if(emp.getSal().isNaN())
			errors.rejectValue("sal", "e.sal.numeric");
			
		
		if(emp.getDesg()==null) 
			errors.rejectValue("desg", "e.desg.required");
		else if(emp.getDesg().length()<5)
			errors.rejectValue("desg", "e.desg.length");
		
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "e.deptno.required");
		else if(emp.getDeptno()<10 ||emp.getDeptno()>1000)
			errors.rejectValue("deptno", "e.deptno.range");
	}
}
