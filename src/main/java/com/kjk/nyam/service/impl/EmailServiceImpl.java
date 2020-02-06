package com.kjk.nyam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kjk.nyam.service.EmailService;

@Service
@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public static void main(String[] args) {
		EmailServiceImpl esi = new EmailServiceImpl();
		esi.sendSimpleMessage("skj2366@naver.com", "test Email", "본 메일은 Test용 메일입니다.");
		System.out.println(esi);
	}
}
