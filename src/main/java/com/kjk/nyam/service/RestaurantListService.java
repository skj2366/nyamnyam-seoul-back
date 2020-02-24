package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.RestaurantListVO;

public interface RestaurantListService {

	public List<RestaurantListVO> selectRELList();
	public Integer insertRELOne(RestaurantListVO rel);
	public Integer updateRELOne(RestaurantListVO rel);
	public Integer deleteRELOne(int relNum);
	
	public RestaurantListVO selectRELOneByRelNum(Integer relNum);
	public List<RestaurantListVO> selectRELListByCategory(String relCategory);
	public List<RestaurantListVO> selectRELListWithZoneAndSubway(Integer zoneNum, Integer subwayNum);
	public RestaurantListVO selectRELNumByRELName(String relName, Integer zoneNum, String relStringCategory);
}
