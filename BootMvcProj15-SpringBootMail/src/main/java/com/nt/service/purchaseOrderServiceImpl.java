package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseService")
public class purchaseOrderServiceImpl implements IpurchaseOrder {

	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromEmail;

	@Override
	public String purchase(String[] items, double[] price, String[] email) throws Exception {
         double billAmount=0.0;
         for(double p:price) {
        	billAmount=billAmount+p; 
         }
         String msg=Arrays.toString(items)+" With Prices"+Arrays.toString(price)+" are Purchased with Bill Amount "+billAmount;
         String status=sendMail(msg,email);
		return msg+"----->"+status;
	}
	private String sendMail(String msg,String[]toEmails)throws Exception {
		MimeMessage mssage=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mssage,true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Testing Mail");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("Abinash_Resume.pdf", new ClassPathResource("Abinash_Patra_java_fresher.pdf"));
		sender.send(mssage);
		return "Mail Sent";
	}

}
