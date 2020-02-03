package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("sui")
@Data
public class SubwayInfoVO {
	
	private Integer subwayNum;
	private String subwayName;
	private Integer subwayLine1;
	private Integer subwayLine2;
	private Integer subwayLine3;
	private Integer subwayLine4;
	private Integer subwayLine5;
	private Integer subwayLine6;
	private Integer subwayLine7;
	private Integer subwayLine8;
	private Integer subwayLine9;
	private Integer subwayLine10;
	private Integer subwayLine11;
	private Integer subwayLine12;
	private Integer subwayLine13;
	private Integer subwayLine14;
	private Integer subwayLine15;

	private Integer zoneNum;
}
