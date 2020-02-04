package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.RestaurantListService;
import com.kjk.nyam.vo.RestaurantListVO;

@RestController
public class RestaurantListController {

	@Resource
	private RestaurantListService relService; 
	
	@GetMapping("/rel")
	public List<RestaurantListVO> selectRELList() {
		return relService.selectRELList();
	}
}