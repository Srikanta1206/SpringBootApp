package com.sri.service;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sri.entity.Tourist;
import com.sri.exception.TouristNotFoundException;
import com.sri.repository.TouristRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class TouristServiceMgmtImpl implements ITouristServiceMgmt {

	@Autowired
	private TouristRepository repository;

	@Autowired
	private JavaMailSender sender;

	// @Value("srikanta1206@gmail.com") // static value
	@Value("${spring.mail.username}") // reading the value from properties file
	private String sentFrom;

	@Override
	public String addRecord(Tourist tourist) throws Exception {
		Tourist touristDetails = repository.saveAndFlush(tourist);
		// call mail sent helper method
		sentMail(touristDetails.toString(), new String[] { "srimantakumarsabat@gmail.com", "sksabat12@gmail.com" });
		return touristDetails.gettId() + " Employee register Successfully";
	}

	// helper method
	private void sentMail(String msg, String[] mails) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		System.err.println(sentFrom);

		// set the properties value in MimeMessage object
		helper.setText(msg);
		helper.setSubject("Your Details Recorded in our DBS/W");
		helper.setSentDate(new Date());
		helper.setBcc(mails);
		helper.setFrom(sentFrom);
		helper.addAttachment("Image",
				new UrlResource("https://i.pinimg.com/736x/b7/1a/c1/b71ac1f34f7fd12d6a95ffd66701548b.jpg"));
		// helper.addAttachment("Image of Bus", new ClassPathResource("jagannath.jpg"));
		// sent mail
		sender.send(message);
	}

	@Override
	public Set<Tourist> getAllTouristDetails() {
		List<Tourist> tDetails = repository.findAll();
		// sorting logic for Descending order
		tDetails.sort((t1, t2) -> t1.gettId().compareTo(t2.gettId()) > 0 ? -1 : 1);
		// converting List to set
		// return set of tourist object to controller class of b.logic method
		return new LinkedHashSet<Tourist>(tDetails);
	}

	@Override
	public Tourist getSpecificTouristDetails(Integer tid) throws TouristNotFoundException {
		return repository.findById(tid).orElseThrow(
				()->new TouristNotFoundException("No Tourist Details found based on this tid  :"+tid)						
				);
			}
}
