package com.example.AOI.aws.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	
	//@Qualifier("mailSender")
    private MailSender mailSender;
	@Autowired
	public SendEmailService(MailSender mailSender) {
		this.mailSender = mailSender;
		
	}
	
    public void sendMessage(SimpleMailMessage simpleMailMessage) {
        mailSender.send(simpleMailMessage);
    }
}
