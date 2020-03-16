package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.RestaurantBlogVO;

public interface RestaurantBlogService {
	
	public List<RestaurantBlogVO> selectBlogListByRelNum(int relNum);
	
	public Integer deleteBlogsByRelNum(int relNum);
}
