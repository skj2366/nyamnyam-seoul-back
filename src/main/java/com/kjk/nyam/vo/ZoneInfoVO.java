package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("zoi")
@Data
public class ZoneInfoVO {
	
	private Integer zoneNum;
	private String zoneName;
}
