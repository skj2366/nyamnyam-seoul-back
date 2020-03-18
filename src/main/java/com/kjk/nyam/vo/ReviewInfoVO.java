package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Alias("rei")
@Data
public class ReviewInfoVO {

	private Integer reiNum;
	private Integer reiLike;
	private String reiTitle;
	private String reiDate;
	private String reiTime;
	private String reiTheme;
	private String reiContents; 
	private MultipartFile reiImg1;	
	private String reiImg1Name;
	private MultipartFile reiImg2;
	private String reiImg2Name;
	private MultipartFile reiImg3;
	private String reiImg3Name;
	private String reiCredat;
	private String reiCretim;
	private String reiModdat;
	private String reiModtim;
	private Integer reiCount;
		
	private Integer cuiNum; //FK_유저
	private Integer relNum; //FK_식당리스트
	private Integer zoneNum; //FK_지역
	private Integer subwayNum; // FK_지하철
	
	private String cuiNickname;
	private String cuiName;
	private String relName;
	private String zoneName;
	private String subwayName;
	
}
