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
	
	public Integer crawling() {
		List<String> urlList = new ArrayList<>();
		urlList = readFile();
		RestaurantListVO rlistvo = new RestaurantListVO();				
		int count = 0;
		
		try {			
			for(int i=0; i<=499; i++) {
				//System.out.println("No : " + i);
				Document document = Jsoup.connect(urlList.get(i)).get();
				//이름
				Elements elsName = document.select(".biz_name_area>strong.name");
				String textName = elsName.text();
				String[] names = textName.split(" ");
				rlistvo.setRelName(names[0]);			
				
				//카테고리 String
				Elements elsCategory = document.select(".biz_name_area>span.category");
				String textCategory = elsCategory.text();
				String[] categories = textCategory.split(" ");
//				for(int j=0 ; j<categories.length ; j++) {
//					System.out.print(categories[j] + "--");
//				}				
				rlistvo.setRelStringCategory(categories[0]);

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
						zone = zoiMapper.selectZOIOneByName(addrs[1]).getZoneNum(); //구역 넘버						
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
				//System.out.println(names[0]);
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
				
				rlistvo.setSubwayNum(0); // 일단 지하철역 0으로 insert
				
				
				//insert 실행
				rlistMapper.insertRELOne(rlistvo);
				count++;
				for(int z=1 ; z<=20 ; z++) {
					if(count == 25*z) {
						System.out.println(count + "개 insert");
					}					
				}
				//System.out.println(rlistvo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" ----- THE END -----");
		return count;
	}
	
	
//	public Integer crawlingMenu() {
//		int count = 0;
//		//메뉴 1개만 넣어짐		
//		MenuInfoVO minfovo = new MenuInfoVO();
//		RestaurantListVO relvo = new RestaurantListVO();
//		
//		List<String> urlList = new ArrayList<>();
//		urlList = readFile();
//		for(int i=0; i<=499; i++) {		
//			//System.out.println("No : " + i);
//			Document document;
//			try {
//				document = Jsoup.connect(urlList.get(i)).get();
//				
//				//이름
//				Elements elsName = document.select(".biz_name_area>strong.name");
//				String textName = elsName.text();
//				String[] names = textName.split(" ");
//				minfovo.setMeiRelName(names[0]);
//				
//				//구역
//				Elements elsAddress = document.select(".list_bizinfo .list_item.list_item_address>div>ul>li");				
//				String textAddress = elsAddress.text();
//				String addrs[] = textAddress.split(" ");
//				
//				//카테고리 String
//				Elements elsCategory = document.select(".biz_name_area>span.category");
//				String textCategory = elsCategory.text();
//				String[] categories = textCategory.split(" ");
//
//				String str = "";
//				int zone = 0;
//				
//				for(int j=1; j<=3; j++) {					
//					if(j==1) {
//						zone = zoiMapper.selectZOIOneByName(addrs[1]).getZoneNum(); //구역 넘버	
//					}
//				
////				int matchRelNum = rlistMapper.selectRELNumByRELName(names[0], zone, categories[0]).getRelNum();
////				minfovo.setRelNum(matchRelNum); //식당 번호 매칭				
//				
//				Elements elsMenu = document.select(".list_item.list_item_menu>div");
//				String textMenu = elsMenu.text();
//				
//				String[] menus1 = textMenu.split("대표"); 
//				String menu1 = "";
//				for(int z=0 ; z<menus1.length ; z++) {					
//					menu1 += menus1[z];
//				}
//				String[] menus2 = menu1.split(" ");
//				List<String> menus3 = new ArrayList<>(Arrays.asList(menus2));
//				menus3.remove("");
//				menus3.remove("");
//				
////					for(int u=0 ; u<menus3.size() ; u++) {
////						System.out.println(menus3.get(u));
////					}
//				
//				String price = "";
//				String name = "";
//												
//				price += menus3.get(0);
//				name += menus3.get(1);				
//				minfovo.setMeiPrice(price);
//				
//					if(menus3.get(2).matches(".*원") || menus3.get(2).matches(".*메뉴.*")) {
//						minfovo.setMeiName(name);					
//					} else if(menus3.get(3).matches(".*원") || menus3.get(3).matches(".*메뉴.*") ) {
//						name += menus3.get(2);					
//						minfovo.setMeiName(name);	
//					} else if(menus3.get(4).matches(".*원") || menus3.get(4).matches(".*메뉴.*"))	{
//						name += menus3.get(2);
//						name += menus3.get(3);					
//						minfovo.setMeiName(name);
//					}
//				
//				}
//				//System.out.println(minfovo);
//				meiMapper.insertMEIOne(minfovo);				
//				count ++;
//				for(int y=1 ; y<=20 ; y++) {
//					if(count == 25*y) {
//						System.out.println(count + "개 insert");
//					}					
//				}
//				
//				
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//		}
//
//		System.out.println(" ----- THE END -----");
//		return count;
//	}
	
}