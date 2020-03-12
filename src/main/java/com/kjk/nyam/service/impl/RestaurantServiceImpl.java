package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.RestaurantBlogMapper;
import com.kjk.nyam.service.RestaurantBlogService;
import com.kjk.nyam.vo.RestaurantBlogVO;

@Service
public class RestaurantServiceImpl implements RestaurantBlogService {
	
	@Resource
	private RestaurantBlogMapper rebMapper;

	@Override
	public List<RestaurantBlogVO> selectBlogListByRelNum(int relNum) {
		return rebMapper.selectBlogListByRelNum(relNum);
	}

}
