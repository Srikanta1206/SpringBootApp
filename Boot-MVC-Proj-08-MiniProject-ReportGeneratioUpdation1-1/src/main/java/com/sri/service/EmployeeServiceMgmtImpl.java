package com.sri.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.EmployeeRepo;

@Service
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {

	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username")
	private String sentFrom;
	
	@Override
	public List<Employee> fetchEmployeeList() {
		// fetch record from emp table,sort by employee name
		return repo.findAll(Sort.by("ename"));
	}

	@Override
	public Optional<Employee> addEntity(Employee emp) {

		Employee saveEmp = repo.save(emp);
		
		try {
			mailSent(saveEmp.getEmpno()+" register successful",new String[] {"sksabat12@gmail.com"});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	private void mailSent(String msg,String[] mail) throws Exception{
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setFrom(sentFrom);
		helper.setCc(mail);
		helper.setText(msg);
		helper.setSentDate(new Date());
		helper.setSubject("Yor credentials details");
	
		sender.send(message);
		System.out.println("Mail sented successfully");
	}
}
