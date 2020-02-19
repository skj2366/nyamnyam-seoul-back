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
	
	private String relMonStart;
	private String relMonEnd;
	private String relTueStart;
	private String relTueEnd;
	private String relWedStart;
	private String relWedEnd;
	private String relThuStart;
	private String relThuEnd;
	private String relFriStart;
	private String relFriEnd;
	private String relSatStart;
	private String relSatEnd;
	private String relSunStart;
	private String relSunEnd;
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
}
