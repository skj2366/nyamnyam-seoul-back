package com.kjk.nyam.crawling;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.RestaurantIdVO;

@MapperScan
public interface RestaurantIdMapper {

	public List<RestaurantIdVO> selectREIdList();
}
