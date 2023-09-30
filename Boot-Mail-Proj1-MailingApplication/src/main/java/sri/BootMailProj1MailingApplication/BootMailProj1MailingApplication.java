package sri.BootMailProj1MailingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sri.BootMailProj1MailingApplication.service.ShoppingServiceMgmtImpl;

@SpringBootApplication
public class BootMailProj1MailingApplication {

	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(BootMailProj1MailingApplication.class, args);
	ShoppingServiceMgmtImpl logic=context.getBean("shoppingServiceMgmtImpl", ShoppingServiceMgmtImpl.class);
	try {
		String resultMsg=logic.shop(new String[] {"shirt", "pant"},new double[]{100,200}, new String[] {"ssrikanta2003@gmail.com"});
		System.out.println(resultMsg);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
