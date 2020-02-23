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
		return relMapper.selectRELList();
	}

	@Override
	public Integer insertRELOne(RestaurantListVO rel) {
		return relMapper.insertRELOne(rel);
	}

	@Override
	public Integer updateRELOne(RestaurantListVO rel) {
		return relMapper.updateRELOne(rel);
	}

	@Override
	public Integer deleteRELOne(int relNum) {
		return relMapper.deleteRELOne(relNum);
	}

	@Override
	public List<RestaurantListVO> selectRELListByCategory(String relCategory) {
			if(relCategory == "1" ) {
				System.out.println("한식 선택");
			} else if(relCategory == "2") {
				System.out.println("중식 선택");
			} else if(relCategory == "3") {
				System.out.println("일식 선택");
			} else if(relCategory == "4") {
				System.out.println("양식 선택");
			} else if(relCategory == "5") {
				System.out.println("카페 선택");
			} else {
				System.out.println("기타");
			}
		return relMapper.selectRELListByCategory(relCategory);
	}

	@Override
	public List<RestaurantListVO> selectRELListWithZoneAndSubway(Integer zoneNum, Integer subwayNum) {
		return relMapper.selectRELListWithZoneAndSubway(zoneNum, subwayNum);
	}

	@Override
	public RestaurantListVO selectRELNumByRELName(String relName, Integer zoneNum, String relStringCategory) {
		return relMapper.selectRELNumByRELName(relName, zoneNum, relStringCategory);
	}
}
