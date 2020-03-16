package com.kjk.nyam.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rel")
@Data
public class RestaurantListVO {

	@NotNull
	private Integer relNum;
	private String relName;
	private String relCategory;
	
	private String relStringCategory; //크롤링 때문에
	
	private String relEtcTime;
	
	private Double relLatitude;
	private Double relLongitude;
	private Integer zoneNum;
	private Integer subwayNum;
	
	private String relSubAddress;
	private String relCall;
	
	private String relCredat;
	private String relCretim;
	private String relModdat;
	private String relModtim;
	
	private String meiImg1Name; // 식당 대표이미지 용 , DB에는 없음.
}
