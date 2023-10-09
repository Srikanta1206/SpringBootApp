package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.EmployeeRepo;

@Service
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> fetchEmployeeList() {
		// fetch record from emp table,sort by employee name
		return repo.findAll(Sort.by("ename"));
	}

	@Override
	public Optional<Employee> addEntity(Employee emp) {

		Employee saveEmp = repo.save(emp);
		return Optional.ofNullable(saveEmp);
	}

	@Override
	public String updateEmpDetails(Employee emp) {
		Employee employee = repo.save(emp);
		return employee.getEmpno()+" Updated Successful";
	}

	@Override
	public Employee searchEmpById(int eno) {
		Optional<Employee> opEmp = repo.findById(eno);

		if (opEmp.isPresent()) {
			return opEmp.get();
		} else {
			return opEmp.orElseThrow(() -> {
				throw new IllegalArgumentException("No Record Found");
			});
		}
	}

	@Override
	public String deleteEmpDetails(int eno) {
		repo.deleteById(eno);
		return eno+" record deleted Successful";
	}

	@Override
	public Page<Employee> getPageDate(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}
}
