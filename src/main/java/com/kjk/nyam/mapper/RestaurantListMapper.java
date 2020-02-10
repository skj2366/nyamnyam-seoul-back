package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.RestaurantListVO;

@MapperScan
public interface RestaurantListMapper {

	public List<RestaurantListVO> selectRELList();
	public Integer insertRELOne(RestaurantListVO rel);
	public Integer updateRELOne(RestaurantListVO rel);
	public Integer deleteRELOne(int relNum);

	public List<RestaurantListVO> selectRELListByCategory(String relCategory);
}
