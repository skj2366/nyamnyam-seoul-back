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

import com.kjk.nyam.service.ReviewInfoService;
import com.kjk.nyam.vo.ReviewInfoVO;

@CrossOrigin("http://localhost:80")
@RestController
public class ReviewInfoController {

	@Resource
	private ReviewInfoService reiService;
	
	@GetMapping("/rei")
	public List<ReviewInfoVO> selectREIList() {
		return reiService.selectREIList();
	}
	
	@GetMapping("/rei/{reiNum}")
	public ReviewInfoVO selectREIOne(@PathVariable String reiNum) {
		int rNum = Integer.parseInt(reiNum);
		return reiService.selectREIOne(rNum);
	}
	
	@GetMapping("/reis/{cuiNum}")
	public List<ReviewInfoVO> selectREIListByCuiNum(@PathVariable int cuiNum) {
		return reiService.selectREIListByCuiNum(cuiNum);
	}
	
	@PostMapping("/rei")
	public Integer insertREIOne(@RequestBody ReviewInfoVO rei) {
		return reiService.insertREIOne(rei);
	}
	
	@PutMapping("/rei")
	public Integer updateREIOne(@RequestBody ReviewInfoVO rei) {
		return reiService.updateREIOne(rei);
	}
	
	@DeleteMapping("/rei/{reiNum}")
	public Integer deleteREIOne(@PathVariable("reiNum") int reiNum) {
		return reiService.deleteREIOne(reiNum);
	}
}
