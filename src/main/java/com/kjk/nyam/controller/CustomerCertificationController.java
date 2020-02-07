package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.CustomerCertificationService;
import com.kjk.nyam.vo.CustomerCertificationVO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
public class CustomerCertificationController {

	@Resource
	private CustomerCertificationService cucService;
	
	@GetMapping("/cuc")
	public List<CustomerCertificationVO> selectCUCList() {
		return cucService.selectCUCList();
	}
	
//	@GetMapping("/cuc/email")
//	public CustomerCertificationVO selectCUCByEmail(@RequestBody CustomerCertificationVO cuc) {
//		return cucService.selectCUCByEmail(cuc);
//	}
	
	@GetMapping("/cuc/{cucEmail}")
	public CustomerCertificationVO selectCUCByEmail(@PathVariable("cucEmail") String cucEmail) {
		return cucService.selectCUCByEmail(cucEmail);
	}
	
	@PostMapping("/cuc")
	public Integer insertCUCOne(@RequestBody CustomerCertificationVO cuc) {
		return cucService.insertCUCOne(cuc);
	}
	
	@DeleteMapping("/cuc/{cucEmail}")
	public Integer deleteCUCOne(@PathVariable("cucEmail") String cucEmail) {
		return cucService.deleteCUCOne(cucEmail);
	}
	
}
