package com.kjk.nyam.crawling;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class CrawlingRestaurantService {

	@Resource
	private CrawlingRestaurantDAO crdao;
	
	public RestaurantListVO crawling() {
		//return crdao.crawlingBasic();
		return null;
	}
}