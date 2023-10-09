package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sri.entity.Employee;

public interface IEmployeeServiceMgmt {
	public List<Employee> fetchEmployeeList();
	public Optional<Employee> addEntity(Employee emp);
	public String updateEmpDetails(Employee emp);
	public Employee searchEmpById(int eno);
	public String deleteEmpDetails(int eno);
	
	public Page<Employee> getPageDate(Pageable pageable);
}
