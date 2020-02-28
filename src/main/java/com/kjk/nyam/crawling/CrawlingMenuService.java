package com.kjk.nyam.crawling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.mapper.ZoneInfoMapper;
import com.kjk.nyam.vo.MenuInfoVO;
import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class CrawlingMenuService {
	
	@Resource
	private RestaurantListMapper rlistMapper;
	@Resource
	private ZoneInfoMapper zoiMapper;
	@Resource
	private MenuInfoMapper meiMapper;
	
	public static List<String> readFile() {	
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
	
	public Integer crawlingMenu() {
		int count = 0;
			
		MenuInfoVO minfovo = new MenuInfoVO();
		RestaurantListVO relvo = new RestaurantListVO();
		
		List<String> urlList = new ArrayList<>();
		urlList = readFile();
		for(int i=0; i<=499; i++) {					
			Document document;	
			try {
				document = Jsoup.connect(urlList.get(i)).get();
				
				//전화번호
				Elements elsCall = document.select(".list_item.list_item_biztel>div");
				String textCall = elsCall.text();				
				
				//구역
				Elements elsAddress = document.select(".list_bizinfo .list_item.list_item_address>div>ul>li");				
				String textAddress = elsAddress.text();
				String addrs[] = textAddress.split(" ");
				
				//카테고리 String
				Elements elsCategory = document.select(".biz_name_area>span.category");
				String textCategory = elsCategory.text();
				String[] categories = textCategory.split(" ");

				String str = "";
				int zone = 0;
				
				for(int j=1; j<=3; j++) {					
					if(j==1) {
						zone = zoiMapper.selectZOIOneByName(addrs[1]).getZoneNum(); //구역 넘버	
					}										
				}
				int matchRelNum = rlistMapper.selectRELNumByRELCall(textCall, zone, categories[0]).getRelNum();
				minfovo.setRelNum(matchRelNum); //식당 번호 매칭	
				
				String relName = rlistMapper.selectRELOneByRelNum(matchRelNum).getRelName();
				minfovo.setMeiRelName(relName);
				
				Elements elsMenu = document.select(".list_item.list_item_menu>div>ul>li:nth-child(1)>div");
				String textMenu = elsMenu.text();				
				String[] menus1 = textMenu.split("대표"); 
				String menu1 = "";
				for(int z=0 ; z<menus1.length ; z++) {					
					menu1 += menus1[z];
				}
				
				String[] menus2 = menu1.split(" ");
				List<String> menus3 = new ArrayList<>(Arrays.asList(menus2));
				menus3.remove("");
				minfovo.setMeiPrice(menus3.get(0)); //가격 set
				//System.out.print("가격 : " + menus3.get(0) + " // ");
				
				String menuName = "";
				for(int u=1 ; u < menus3.size() ; u++) {
					menuName += menus3.get(u);
				}
				minfovo.setMeiName(menuName); //메뉴이름 set
				//System.out.println("메뉴이름 : " + menuName);
				
				meiMapper.insertMEIOne(minfovo);
				count ++;
				for(int y=1 ; y<=20 ; y++) {
					if(count == 25*y) {
						System.out.println(count + "개 insert");
					}					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				return count;
			}			
		}
		System.out.println(" ----- THE END -----");
		return count;
	}
	

}
