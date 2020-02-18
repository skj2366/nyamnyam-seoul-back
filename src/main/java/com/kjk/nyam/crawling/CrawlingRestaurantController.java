package com.kjk.nyam.crawling;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.vo.RestaurantIdVO;
import com.kjk.nyam.vo.RestaurantListVO;

@RestController
public class CrawlingRestaurantController {
	
	@Resource
	private CrawlingRestaurantService crservice;
	
	@GetMapping("/urlList")
	public String getUrl() {
		return null;
		//return crservice.getUrl();
	}
	
	@GetMapping("/crawling")
	public RestaurantListVO getRestaurant() {
		return crservice.crawling();
	}
	
	@GetMapping("/time")
	public String getTime() {
		return crservice.timeCrawling();
	}
	
}