package com.kjk.nyam.service.impl;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kjk.nyam.service.CustomerCertificationService;
import com.kjk.nyam.service.EmailService;
import com.kjk.nyam.vo.CustomerCertificationVO;
import com.kjk.nyam.vo.CustomerInfoVO;

@Service
@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	public JavaMailSender emailSender;

	@Resource
	private CustomerCertificationService cucService;
	
	private int certCharLength = 6;
	private final char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };


	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public static void main(String[] args) {
		int certCharLength = 6;
		char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
	            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
	            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		
		Random random = new Random(System.currentTimeMillis());
		int tableLength = characterTable.length;
		StringBuffer buff = new StringBuffer();
		for(int i = 0; i < certCharLength; i++) {
			buff.append(characterTable[random.nextInt(tableLength)]);
		}
		String text = buff.toString();
		System.out.println(text);
	}

	@Override
	public String sendEmail(CustomerInfoVO cui) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(cui.getCuiEmail());
		message.setSubject("인증메일");
		
		// 랜덤 인증 번호 생성 ( 숫자 + 영문 ) 시작
		Random random = new Random(System.currentTimeMillis());
		int tableLength = characterTable.length;
		StringBuffer buff = new StringBuffer();
		for(int i = 0; i < certCharLength; i++) {
			buff.append(characterTable[random.nextInt(tableLength)]);
		}
		String text = buff.toString();
		// 랜덤 인증 번호 생성 끝
		
		message.setText(text);

		CustomerCertificationVO cuc = new CustomerCertificationVO();
		
		int cucDelResult = 0;
		cuc = cucService.selectCUCByEmail(cui.getCuiEmail());
		System.out.println(cuc);
		if(cuc != null) {
			cucDelResult = cucService.deleteCUCOne(cui.getCuiEmail());
		}else {
			cuc = new CustomerCertificationVO();
		}
		
		cuc.setCucCerNum(text);
		cuc.setCucEmail(cui.getCuiEmail());
		
		int saveCerNum = cucService.insertCUCOne(cuc);
		System.out.println("saveCerNum : " + saveCerNum);
		if(saveCerNum == 1) {
//			emailSender.send(message); //이메일 전송 
			return text;
		}else {
			return null;
		}
		
		
	}
	
}
