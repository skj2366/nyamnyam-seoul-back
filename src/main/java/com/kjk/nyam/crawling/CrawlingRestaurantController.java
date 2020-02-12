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
	public Integer getRestaurantIdByUrl() {
		
		return 0;
	}
	
}
