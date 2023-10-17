package com.email.service.GemailService;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class GemailService {

	public Boolean sendMail(String to , String from, String text) {
		Boolean flag = false;
		Properties props = new Properties();
		String userName = "abhaysinghjprk6";
		String password = "wwuepjriavnwwmtl";
		try {
		FileInputStream inputStream = new FileInputStream("src/main/resources/application.properties");
		props.load(inputStream);
		
		Session session = Session.getInstance(props, new Authenticator() {
			
			@Override
			 protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName,password);
				    }
		});
		
		Message message  = new MimeMessage(session);
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setFrom(new InternetAddress(from));
		message.setSubject("generated message for testing");
		message.setText(text);
		Transport.send(message);
		flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
}

}
		
	

