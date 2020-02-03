package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.service.RestaurantListService;
import com.kjk.nyam.vo.RestaurantListVO;

@Service
public class RestaurantListSerivceImpl implements RestaurantListService {

	@Resource
	private RestaurantListMapper relMapper;

	@Override
	public List<RestaurantListVO> selectRELList() {
		// TODO Auto-generated method stub
		return relMapper.selectRELList();
	}
}
