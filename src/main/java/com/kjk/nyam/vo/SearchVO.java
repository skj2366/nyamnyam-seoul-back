package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("search")
@Data
public class SearchVO {

	private Integer zoneNum;
	private Integer subwayNum;
	private String relName;
	private Integer solo;
	private Integer two;
	private Integer four;
	private String total;
	
}
