package com.kjk.nyam.crawling;

import lombok.Data;

@Data
public class CrawlingRestaurantVO {

	private String url;
	private String id;
	
	private String rName;
	private String rAddr1; //도로명 주소
	private String rAddr2; //지번주소 + 상세주소
	private String call;
	
	private String time1;
	private String time2;
	private String time3;
	private String time4;
	private String time5;
	private String time6;
	private String time7;
	
	private String menu1;
	private String menu2;
	private String menu3;
	private String menu4;
	private String menu5;
	
}
