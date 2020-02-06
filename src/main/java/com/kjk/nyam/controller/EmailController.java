package com.kjk.nyam.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.EmailService;

@RestController
public class EmailController {

	@Resource
	public EmailService EmailService;
	
	@GetMapping("/mailtest")
	public void sendMail() {
		EmailService.sendSimpleMessage("skj2366@naver.com", "Asdasdasd", "asdasdasd");
		
	}
}
