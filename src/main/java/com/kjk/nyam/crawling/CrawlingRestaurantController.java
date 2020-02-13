package com.kjk.nyam.crawling;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.vo.RestaurantListVO;

@RestController
public class CrawlingRestaurantController {
	
	@Resource
	private CrawlingRestaurantService crservice;
	
	@GetMapping("/crawling")
	public RestaurantListVO getRestaurant() {
		return crservice.crawling();
	}
	
}