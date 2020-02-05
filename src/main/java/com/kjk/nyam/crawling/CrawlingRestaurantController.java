package com.kjk.nyam.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlingRestaurant {

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
	
	
}
