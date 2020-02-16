package com.kjk.nyam.crawling;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.RestaurantIdMapper;
import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class CrawlingRestaurantService {

	@Resource
	private RestaurantListMapper rlistMapper;
	
// 파일완성
//	@Resource
//	private RestaurantIdMapper reIdMapper;
//	
//	public String getUrl() {
//		DataOutputStream dos = null;
//		try {
//			dos = new DataOutputStream(new FileOutputStream("urlid.txt"));
//			String url = "https://store.naver.com/restaurants/detail?";
//			for(int i=0 ; i<reIdMapper.selectREIdList().size() ; i++) {
//				String reiGugun = reIdMapper.selectREIdList().get(i).getReiGugun();
//				String reiId = reIdMapper.selectREIdList().get(i).getReiId();
//				dos.writeUTF(i + " " + reiGugun + " ==> " + url + reiId + "\n");
//			}			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
//		return "성공";
//	}
	
	public static List<String> readFile() {
		int n;		
		String[] urls;
		List<String> urlList = new ArrayList<String>();
		BufferedReader bure = null;
		
		try {
			bure = new BufferedReader(new FileReader("urlid.txt"));
			String str = "";
			while((str = bure.readLine()) != null) {
				urls = str.split(" ");
				urlList.add(urls[3]);
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlList;
	}
	
	public RestaurantListVO crawling() {
		List<String> urlList = new ArrayList<>();
		urlList = readFile();
		RestaurantListVO rlistvo = new RestaurantListVO();
		
		try {			
			for(int i=0; i<=3; i++) {
				System.out.println("No : " + i);
				Document document = Jsoup.connect(urlList.get(i)).get();
				Elements elsName = document.select(".biz_name_area>strong.name");
				String textName = elsName.text();
				String[] names = textName.split(" ");
				rlistvo.setRelName(names[0]);				

				Elements elsCall = document.select(".list_item.list_item_biztel>div");
				String textCall = elsCall.text();
				rlistvo.setRelCall(textCall);
				
				Elements elsAddress = document.select(".list_item.list_item_address>div>ul>li");
				String textAddress = elsAddress.text();
				String addrs[] = textAddress.split(" ");
				for(int j=0; j<addrs.length; j++) {
					System.out.println(addrs[j]);
				}
				//rlistMapper.insertRELOne(rlistvo);
				System.out.println(rlistvo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		return null;
	}
}