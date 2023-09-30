package sri.BootMailProj1MailingApplication.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ShoppingServiceMgmtImpl implements IService{

	@Autowired
	private JavaMailSender sender;
	@Override
	public String shop(String[] product, double[] prices, String[] mails) throws Exception {
		double billAmt=0;
		for(double price:prices)
			billAmt+=price;
		String message=Arrays.toString(product)+" prices are "+Arrays.toString(prices)+" toal bill amt is "+billAmt;
		String res=sendMail(message, mails);
		return res;	
	}
	
	//helper class
	private String sendMail(String msg,String[] mails) throws MessagingException {
		//create empty mail sender message  
		MimeMessage message=sender.createMimeMessage();//factory design pattern
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom("srikanta1206@gmail.com");
		helper.setCc(mails);
		helper.setSubject("Product order details");
		helper.setSentDate(new Date());
		helper.setText(msg);
		
		sender.send(message);
		return "mail sent";
	}

}
