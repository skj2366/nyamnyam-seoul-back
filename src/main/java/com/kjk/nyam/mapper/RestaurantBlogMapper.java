package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.RestaurantBlogVO;

@MapperScan
public interface RestaurantBlogMapper {
	
	public List<RestaurantBlogVO> selectBlogListByRelNum(int relNum);
	public Integer deleteBlogsByRelNum(int relNum);

}
