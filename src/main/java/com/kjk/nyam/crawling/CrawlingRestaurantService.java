package com.kjk.nyam.crawling;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.MenuInfoMapper;
import com.kjk.nyam.mapper.RestaurantIdMapper;
import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.mapper.ZoneInfoMapper;
import com.kjk.nyam.vo.MenuInfoVO;
import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class CrawlingRestaurantService {

	@Resource
	private RestaurantListMapper rlistMapper;
	@Resource
	private ZoneInfoMapper zoiMapper;
	@Resource
	private MenuInfoMapper meiMapper;
	
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
			for(int i=0; i<=5; i++) {
				System.out.println("No : " + i);
				Document document = Jsoup.connect(urlList.get(i)).get();
				//이름
				Elements elsName = document.select(".biz_name_area>strong.name");
				String textName = elsName.text();
				String[] names = textName.split(" ");
				rlistvo.setRelName(names[0]);				

				//전화번호
				Elements elsCall = document.select(".list_item.list_item_biztel>div");
				String textCall = elsCall.text();
				rlistvo.setRelCall(textCall);
				
				//주소
				Elements elsAddress = document.select(".list_bizinfo .list_item.list_item_address>div>ul>li");				
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
				System.out.println(names[0]);
				//System.out.println(textCall);
				//System.out.println(str);
				rlistvo.setRelSubAddress(str);
				
				//시간
				Elements elsTime = document.select(".list_item.list_item_biztime>div");
				String textTime = elsTime.text();
				String[] times = textTime.split(" ");
				for(int j=0 ; j<times.length ; j++) {
					//System.out.print(times[j] + " // ");
				}
				//System.out.println("===============" + i + "번째 완료");
				rlistvo.setRelEtcTime(textTime);
				
//				rlistMapper.insertRELOne(rlistvo);
//				System.out.println(rlistvo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" ----- THE END -----");
		return null;
	}
	
	
	public MenuInfoVO crawlingMenu() {
		//메뉴		
		MenuInfoVO minfovo = new MenuInfoVO();
		List<String> urlList = new ArrayList<>();
		urlList = readFile();
		for(int i=0; i<=10; i++) {		
			System.out.println("No : " + i);
			Document document;
			try {
				document = Jsoup.connect(urlList.get(i)).get();
				
				//이름
				Elements elsName = document.select(".biz_name_area>strong.name");
				String textName = elsName.text();
				String[] names = textName.split(" ");			
				
				Elements elsMenu = document.select(".list_item.list_item_menu>div");
				String textMenu = elsMenu.text();
				
				String[] menus1 = textMenu.split("대표");
				String menu1 = "";
				for(int j=0 ; j<menus1.length ; j++) {					
					menu1 += menus1[j];
				}
				String[] menus2 = menu1.split(" ");
				List<String> menus3 = new ArrayList<>(Arrays.asList(menus2));
				menus3.remove("");
				menus3.remove("");
				String price = "";
				String name = "";
											
				minfovo = new MenuInfoVO();
				minfovo.setMeiRelName(names[0]);
				
				price += menus3.get(0);
				name += menus3.get(1);
				minfovo.setMeiPrice(price);
				if(menus3.get(2).matches(".*원")) {
					minfovo.setMeiName(name);
				} else if(menus3.get(3).matches(".*원") ) {
					name += menus3.get(2);
					minfovo.setMeiName(name);	
				} else if(menus3.get(4).matches(".*원"))	{
					name += menus3.get(2);
					name += menus3.get(3);
					minfovo.setMeiName(name);
				}			
				System.out.println(minfovo);
				//meiMapper.insertMEIOne(minfovo);						
				
				System.out.println("===============" + i + "번째 완료");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};						
		}
		return null;
	}
	
}