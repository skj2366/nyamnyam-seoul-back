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

import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.vo.RestaurantIdVO;
import com.kjk.nyam.vo.RestaurantListVO;

@Repository
public class CrawlingRestaurantDAO {
	
//	@Resource
//	private RestaurantIdMapper reIdMapper;

	@Resource
	private RestaurantListMapper relMapper;
	
//	public List<RestaurantIdVO> getId() {		
//		return reIdMapper.selectREIdList();
//	}
	
//	public RestaurantListVO crawlingBasic() {
//		List<String> urlList = new ArrayList();
//		RestaurantListVO relvo = new RestaurantListVO();
//		System.out.println(getId().size());
//		for(int i=0; i<getId().size() ; i++) {
//			String url = "https://store.naver.com/restaurants/detail?";
//			url += getId().get(i).get("reiId");
//			System.out.println("url :" + url);
//			urlList.add(url);
//		}
//
//		try {
//
//			for(int i=0; i<=3; i++) {
//				System.out.println("No : " + i);
//				Document document = Jsoup.connect(urlList.get(i)).get();
//				Elements elsName = document.select(".biz_name_area>strong.name");
//				String textName = elsName.text();
//				String[] names = textName.split(" ");
//				relvo.setRelName(names[0]);
//				System.out.println(relvo.getRelName());
//
//				Elements elsCall = document.select(".list_item.list_item_biztel>div");
//				String textCall = elsCall.text();
//				relvo.setRelCall(textCall);
//				
//				Elements elsAddress = document.select(".list_item.list_item_address>div>ul>li");
//				String textAddress = elsAddress.text();
//				String addrs[] = textAddress.split(" ");
////				for(int j=0; j<addrs.length; j++) {
////					System.out.println(addrs[j]);
////				}
////				relMapper.insertRELOne(relvo);
//				System.out.println(relvo);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return relvo;		
//	}
	
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
//		relvo = crdao.crawlingBasic();
	}
}
