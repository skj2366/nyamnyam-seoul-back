package com.kjk.nyam.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.EmailService;
import com.kjk.nyam.vo.CustomerInfoVO;

@RestController
@CrossOrigin("*")
public class EmailController {

	@Resource
	public EmailService EMService;
	
	@GetMapping("/sendmail")
	public void sendMail() {
		EMService.sendSimpleMessage("skj2366@naver.com", "Asdasdasd", "asdasdasd");
	}
	
	@PostMapping("/send")
	public String sendMailing(@RequestBody CustomerInfoVO cui) {
		System.out.println("#####################");
		System.out.println(cui);
		return EMService.sendEmail(cui); 
	}
}
