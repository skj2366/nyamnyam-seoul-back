package com.kjk.nyam.service;

import com.kjk.nyam.vo.CustomerInfoVO;

public interface EmailService {

	public void sendSimpleMessage(String to, String subject, String text);

	public String sendEmail(CustomerInfoVO cui);
	
}
