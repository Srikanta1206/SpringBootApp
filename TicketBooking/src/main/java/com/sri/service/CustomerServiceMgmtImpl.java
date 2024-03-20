package com.sri.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sri.model.Customer;
import com.sri.repository.ITicketBookingRepo;

import jakarta.mail.internet.MimeMessage;

@Service
@Scope("singleton")
public class CustomerServiceMgmtImpl implements ICustomerService {

	@Autowired
	private ITicketBookingRepo repo;

	@Autowired
	private JavaMailSender sender;

	@Value("${spring.mail.username}")
	private String from;

	@Override
	public boolean fetchCustomerData(String username, String password) throws Exception {
		boolean data = repo.findByUsernameAndPassword(username, password);

		boolean result = data ? true : false;
		return result;
	}

	@Override
	public String register(Customer customer) throws Exception {
		Customer cust = repo.save(customer);

		sentMail(new String[] { customer.getEmail()});
		return "Client register with username :" + cust.getUsername();
	}

	private String sentMail(String[] args) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setSubject("Regarding Registration");
		helper.setCc(args);
		helper.setTo(args);
		helper.setSentDate(Date.valueOf(LocalDate.now()));
		helper.addAttachment("Train symbol", new ClassPathResource("train.png"));
		helper.setText("Registration complete");
		sender.send(message);
		return "message sent successfully";
	}
}
