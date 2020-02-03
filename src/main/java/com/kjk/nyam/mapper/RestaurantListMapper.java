package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.RestaurantListVO;

@MapperScan
public interface RestaurantListMapper {

	public List<RestaurantListVO> selectRELList();
}
