package com.kjk.nyam.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlingRestaurantController {

	@GetMapping("/crawling")
	public static void crawling() {
		String url = "https://store.naver.com/restaurants/detail?id=1016650284";
		System.out.println("url : " + url);
		try {
			Document document = Jsoup.connect(url).get();
			Elements els01 = document.select(".biz_name_area");
			String text01 = els01.text();
			System.out.println(text01);
			Elements els02 = document.select(".bizinfo_area");
			String text02 = els02.text();
			System.out.println(text02);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/getid")
	public Integer getRestaurantIdByUrl() {
		String url = "https://store.naver.com/restaurants/list?entry=pll&filterId=s13469878&query=%EA%B0%80%EC%82%B0%EB%94%94%EC%A7%80%ED%84%B8%EB%8B%A8%EC%A7%80%EC%97%AD%20%EB%A7%9B%EC%A7%91&sessionid=c4U1pu4AzA44vR2cWtt%2FlQ%3D%3D";
		
		try {			
			Document document = Jsoup.connect(url).get();
			Elements els = document.select(".list_area>ul.list_place_col1>li");
			for(Element el:els) {				
				System.out.print(el);
				return els.size();
			}
		} catch (IOException e) {
			System.out.print(e);
		}
		return 0;
	}
	
}