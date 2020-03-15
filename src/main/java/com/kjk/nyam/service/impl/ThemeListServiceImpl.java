package com.kjk.nyam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.RestaurantListMapper;
import com.kjk.nyam.mapper.ThemeListMapper;
import com.kjk.nyam.service.ThemeListService;
import com.kjk.nyam.vo.RestaurantListVO;
import com.kjk.nyam.vo.ThemeListVO;

@Service
public class ThemeListServiceImpl implements ThemeListService {

	@Resource
	private ThemeListMapper thlMapper;
	@Resource
	private RestaurantListMapper relMapper;
	
	@Override
	public List<ThemeListVO> selectTHLList() {
		return thlMapper.selectTHLList();
	}

	@Override
	public Integer insertTHLList() { // 사용 XXXXXXXXXXXXXXX
		int count = 0;
		ThemeListVO thlVO = new ThemeListVO();
		List<RestaurantListVO> restaurants = new ArrayList<RestaurantListVO>();
		restaurants = relMapper.selectRELList();
		restaurants.remove(0);
		restaurants.remove(0);
		
		// 2인은 모두 다 세팅
		
		for(int i = 0 ; i<restaurants.size(); i++) {
			thlVO.setRelNum(restaurants.get(i).getRelNum());
			thlVO.setThlSolo(0);
			thlVO.setThlCouple(1);
			thlVO.setThlFour(0);
			
			if(restaurants.get(i).getRelStringCategory().matches(".*육류.*")
				|| restaurants.get(i).getRelStringCategory().matches(".*구이.*")
				|| restaurants.get(i).getRelStringCategory().matches(".*한정식.*")
				|| restaurants.get(i).getRelStringCategory().matches(".*요리.*")
				|| restaurants.get(i).getRelStringCategory().matches(".*찜.*")) {
					thlVO.setThlFour(1);
			} else if(restaurants.get(i).getRelStringCategory().matches(".*카페.*")
						|| restaurants.get(i).getRelStringCategory().matches(".*분식.*")
						|| restaurants.get(i).getRelStringCategory().matches(".*기사.*")
						|| restaurants.get(i).getRelStringCategory().matches(".*와인.*")) {
					thlVO.setThlSolo(1);
			}
			//thlMapper.insertTHLList(thlVO);
			count++;
		}
		return count;
	}

	@Override
	public Integer insertTHLOne(ThemeListVO thlVO) {
		return thlMapper.insertTHLList(thlVO);
	}

}
