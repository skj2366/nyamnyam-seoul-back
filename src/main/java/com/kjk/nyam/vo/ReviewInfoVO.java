package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rei")
@Data
public class ReviewInfoVO {

	private Integer reiNum;
	private Integer reiLike;
	private String reiTitle;
	private String reiDate;
	private String reiTime;
	private String reiContents; //clob??
	private String reiImg1Name;
	private String reiImg2Name;
	private String reiImg3Name;
	private String reiCredat;
	private String reiCretim;
	private String reiModat;
	private String reiMotim;
	
	
	private Integer cuiNum; //FK_유저
	private Integer relNum; //FK_식당리스트
	private Integer zoneNum; //FK_지역
	private Integer subwayNum; // FK_지하철
	
}
