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
import com.kjk.nyam.mapper.ZoneInfoMapper;
import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class CrawlingRestaurantService {

	@Resource
	private RestaurantListMapper rlistMapper;
	@Resource
	private ZoneInfoMapper zoiMapper;
	
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
			for(int i=150; i<=170; i++) {
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
				
				String str = "";
				int zone = 0;
				
				for(int j=1; j<=addrs.length-1; j++) {					
					if(j==1) {
						zone = zoiMapper.selectZOIListByName(addrs[1]).getZoneNum();
						rlistvo.setZoneNum(zone);
					}
					if(j==4) {						
						addrs[j] = "/ 지번주소 : " + addrs[j].substring(2);						
					}
					if(j==addrs.length-1) {
						addrs[j] = addrs[j].substring(0, addrs[j].length()-4);
					}
					
					str += addrs[j] + " ";
				}				
				System.out.println(str);
				rlistvo.setRelSubAddress(str);
				
				
				//rlistMapper.insertRELOne(rlistvo);
				//System.out.println(rlistvo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}				
		return null;
	}
}