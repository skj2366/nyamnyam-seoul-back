package com.kjk.nyam.crawling;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.vo.MenuInfoVO;
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
	public Integer getRestaurant() {
		return crservice.crawling();
	}
	
	@GetMapping("/menu")
	public Integer getMenu() {
		return crservice.crawlingMenu();
	}
	
	
}