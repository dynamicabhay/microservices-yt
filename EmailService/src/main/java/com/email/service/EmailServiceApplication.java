package com.email.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.email.service.GemailService.GemailService;

@SpringBootApplication
public class EmailServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*/ TODO Auto-generated method stub
		System.out.println("application started");
	GemailService svc = 	new GemailService();
	String to = "abhaysinghshekhawat5369@gmail.com";
	String from = "abhaysinghjprk6@gmail.com";
	String text = "hi chiru";
	Boolean res = svc.sendMail(to, from, text);
	if(res) {
		System.out.println("data sent successfully");
		
	}else {
		System.out.println("something went wrong");
	}
		
	} */
	}

}
