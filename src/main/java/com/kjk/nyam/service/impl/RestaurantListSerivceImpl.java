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

	@Override
	public List<RestaurantListVO> selectRELListWithTheme(String theme) {
		System.out.println("service theme : " + theme);
		String themeKey = "";
		String themeValue = "1";
		if("alone".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "thl.THL_SOLO";
		}else if("two".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "thl.THL_COUPLE";
		}else if("more".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "thl.THL_FOUR";
		}else if("korean".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
		}else if("chinese".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
			themeValue = "2";
		}else if("form".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
			themeValue = "3";
		}else if("japanese".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
			themeValue = "4";
		}else if("dessert".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
			themeValue = "5";
		}else if("etc".equals(theme)) {
			System.out.println(" theme is " + theme);
			themeKey = "rel.REL_CATEGORY";
			themeValue = "6";
		}
		System.out.println("themeKey : " + themeKey);
		return relMapper.selectRELListWithTheme(themeKey, themeValue);
	}
}
