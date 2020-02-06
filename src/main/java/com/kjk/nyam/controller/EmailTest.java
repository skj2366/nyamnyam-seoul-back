package com.kjk.nyam.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailTest {

	@Autowired
	private static JavaMailSender sender;
	
	private static void sendEmail() throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo("skj2366@naver.com");
		helper.setText("안녕!");
		helper.setSubject("안녕하세요");
		
		sender.send(message);
	}
	
	public static void main(String[] args) throws Exception {
		sendEmail();
	}
}
