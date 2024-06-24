package com.example.AOI.aws.email.test;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import com.example.AOI.aws.email.SendEmailService;
import com.example.AOI.aws.email.AmazonSESConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.junit.jupiter.api.Test;
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
//@BootstrapWith
//@ContextConfiguration(classes = AmazonSESConfig.class)
public class EmailApplicationTests   {
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
	
	public void setup() {
        //mockMvc = MockMvcBuilders.standaloneSetup(endpoint).build();
        //is = endpoint.getClass().getClassLoader().getResourceAsStream("Snake_River.jpg");
    }
	
	@Autowired
	SendEmailService emailService;
	
	@Test 
	public void sendMessage() {
		 
		  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		  simpleMailMessage.setFrom("girish.kempaiah@alphaomega.com");
		  simpleMailMessage.setTo("girishmk73@gmail.com");
		  simpleMailMessage.setSubject("Test email from AOI to Girish");
		  simpleMailMessage.setText("Hello Girish, This is a test email message");
		  emailService.sendMessage(simpleMailMessage);
		  
		  System.out.println(" Email send successfully");
		  
	}

}
