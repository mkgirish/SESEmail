package com.example.AOI.aws.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

import io.awspring.cloud.ses.SimpleEmailServiceJavaMailSender;
import io.awspring.cloud.ses.SimpleEmailServiceMailSender;

@Configuration
//@ComponentScan
public class AmazonSESConfig {
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private String region;

	@Bean(name="emailService")
	public AmazonSimpleEmailService amazonSimpleEmailService() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();
	}

	@Bean(name="mailSender")
	public MailSender mailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		return new SimpleEmailServiceMailSender(amazonSimpleEmailService);
	}

	
	 @Bean(name="javaEmailSender")
	 public JavaMailSender javaMailSender(AmazonSimpleEmailService amazonSimpleEmailService) { 
		 return new SimpleEmailServiceJavaMailSender(amazonSimpleEmailService); }
	 

}
