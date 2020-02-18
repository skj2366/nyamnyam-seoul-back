package com.kjk.nyam.crawling;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import com.kjk.nyam.mapper.RestaurantIdMapper;
import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.vo.RestaurantIdVO;
import com.kjk.nyam.vo.RestaurantListVO;

public class CrawlingRestaurantDAO {

	public static void timeCrawling() {
//		url += "1913875816";
//		System.out.println("url : " + url);
//		
//		//매일만 표시되어있을 경우 ex)매일 16:00 - 03:00
//		try {
//			Document document = Jsoup.connect(url).get();
//			Elements elsTime = document.select(".biztime_row>div>span>span");
//			String textTime = elsTime.text();
//			System.out.println(textTime);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void menuCrawling() {
//		url += "1913875816";
//		System.out.println("url : " + url);
//				
//		try {
//			Document document = Jsoup.connect(url).get();
//			Elements elsMenu = document.select(".list_item.list_item_menu>div>ul>li");
//			String textMenu = elsMenu.text();
//			
//			String menus[] = textMenu.split(" ");
//			
//			for(int i=0; i<menus.length; i++) {
//				System.out.println(menus[i]);
//			}						
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	
	public static void main(String[] args) {
//		CrawlingRestaurantDAO crdao = new CrawlingRestaurantDAO();
//		RestaurantListVO relvo = new RestaurantListVO();
//		List<RestaurantIdVO> test = new ArrayList<RestaurantIdVO>();
//		System.out.println(getId());
		//relvo = crdao.crawlingBasic();
	}
}