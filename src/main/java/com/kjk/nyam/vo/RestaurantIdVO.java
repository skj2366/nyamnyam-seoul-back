package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("reId")
@Data
public class RestaurantIdVO {

	private Integer reiNum;
	private String reiGugun;
	private String reiId;
}
