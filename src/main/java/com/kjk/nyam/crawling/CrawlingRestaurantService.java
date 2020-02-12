package com.kjk.nyam.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class CrawlingRestaurantService {

	static String url = "https://store.naver.com/restaurants/detail?id=";
	  
	public static void crawling() {
		url += "1913875816";
		System.out.println("url : " + url);
		try {
			Document document = Jsoup.connect(url).get();
			Elements elsName = document.select(".biz_name_area>strong.name");
			String textName = elsName.text();
			System.out.println(textName);
			
			Elements elsCall = document.select(".list_item.list_item_biztel>div");
			String textCall = elsCall.text();
			System.out.println(textCall);
			
			Elements elsAddress = document.select(".list_item.list_item_address>div>ul>li");
			String textAddress = elsAddress.text();
			String addrs[] = textAddress.split(" ");
			
			for(int i=0; i<addrs.length; i++) {
				System.out.println(addrs[i]);
			}
			
			
//			Elements elsAddress2 = document.select(".list_item.list_item_address>div");
//			String textAddress2 = elsAddress1.text();
//			System.out.println(textAddress2);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void timeCrawling() {
		url += "1913875816";
		System.out.println("url : " + url);
		
		//매일만 표시되어있을 경우 ex)매일 16:00 - 03:00
		try {
			Document document = Jsoup.connect(url).get();
			Elements elsTime = document.select(".biztime_row>div>span>span");
			String textTime = elsTime.text();
			System.out.println(textTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void menuCrawling() {
		url += "1913875816";
		System.out.println("url : " + url);
				
		try {
			Document document = Jsoup.connect(url).get();
			Elements elsMenu = document.select(".list_item.list_item_menu>div>ul>li");
			String textMenu = elsMenu.text();
			
			String menus[] = textMenu.split(" ");
			
			for(int i=0; i<menus.length; i++) {
				System.out.println(menus[i]);
			}						
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//crawling();
		//timeCrawling();
		menuCrawling();
	}
}
