package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.CustomerInfoService;
import com.kjk.nyam.vo.CustomerInfoVO;

@CrossOrigin("*")
@RestController
public class CustomerInfoController {

	@Resource
	private CustomerInfoService cuiService;
	
	@GetMapping("/cui")
	public List<CustomerInfoVO> selectCUIList() {
		return cuiService.selectCUIList();
	}
	
	@PostMapping("/cui")
	public Integer insertCUIOne(@RequestBody CustomerInfoVO cui) {
		return cuiService.insertCUIOne(cui);
	}
	
	@PutMapping("/cui")
	public Integer updateCUIOne(@RequestBody CustomerInfoVO cui) {
		return cuiService.updateCUIOne(cui);
	}
	
	@DeleteMapping("/cui/{cuiNum}")
	public Integer deleteCUIOne(@PathVariable("cuiNum") int cuiNum) {
		System.out.println("######################");
		System.out.println(cuiNum);
		return cuiService.deleteCUIOne(cuiNum);
	}
}
