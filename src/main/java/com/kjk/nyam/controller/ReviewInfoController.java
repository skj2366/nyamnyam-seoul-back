package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.ReviewInfoService;
import com.kjk.nyam.vo.ReviewInfoVO;

@RestController
public class ReviewInfoController {

	@Resource
	private ReviewInfoService reiService;
	
	@GetMapping("/rei")
	public List<ReviewInfoVO> selectREIList() {
		return reiService.selectREIList();
	}
}
