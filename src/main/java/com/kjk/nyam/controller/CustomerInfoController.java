package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.CustomerInfoService;
import com.kjk.nyam.vo.CustomerInfoVO;


@RestController
public class CustomerInfoController {

	@Resource
	private CustomerInfoService cuiService;
	
	@GetMapping("/cui")
	public List<CustomerInfoVO> selectCUIList() {
		return cuiService.selectCUIList();
	}
}
