package com.kjk.nyam.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjk.nyam.service.LoginService;
import com.kjk.nyam.vo.CustomerInfoVO;

@CrossOrigin("*")
@Controller
public class LoginController {

	@Resource
	private LoginService loginService;
	
	@PostMapping("/login")
	public @ResponseBody CustomerInfoVO doLogin(@RequestBody CustomerInfoVO cui) {
		return loginService.doLogin(cui);
	}
}
