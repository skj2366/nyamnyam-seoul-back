package com.kjk.nyam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.MenuInfoMapper;
import com.kjk.nyam.service.MenuInfoService;
import com.kjk.nyam.vo.MenuInfoVO;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	@Resource
	private MenuInfoMapper meiMapper;
	
	@Override
	public List<MenuInfoVO> selectMEIList() {
		return meiMapper.selectMEIList();
	}
	
	@Override
	public List<MenuInfoVO> selectMEIListByRelNum(int relNum) {
		return meiMapper.selectMEIListByRelNum(relNum);
	}

	@Override
	public Integer insertMEIOne(MenuInfoVO mei) {
		return meiMapper.insertMEIOne(mei);
	}

	@Override
	public Integer updateMEIOne(MenuInfoVO mei) {
		return meiMapper.updateMEIOne(mei);
	}

	@Override
	public Integer deleteMEIOne(int meiNum) {
		return meiMapper.deleteMEIOne(meiNum);
	}

	@Override
	public Integer averagePriceByRelNum(int relNum) {		
		List<MenuInfoVO> menuList = new ArrayList<MenuInfoVO>();
		menuList = meiMapper.selectMEIListByRelNum(relNum);
		int sumPrice = 0;
		int avgPrice = 0;
		String getPrice = "";
		List<Integer> priceList = new ArrayList<Integer>();
		
		for (int i=0 ; i < menuList.size() ; i++) {
			getPrice = menuList.get(i).getMeiPrice();
			if(getPrice.matches(".*변동.*")) {
				System.out.println(getPrice);
			} else if(getPrice.matches(".*~.*")) {
				String[] cut1 = getPrice.split("~");
				for(int z=0 ; z<cut1.length ; z++) {
					String cutWon = "";
					if(cut1[z].matches(".*원.*")) {
						cutWon = cut1[z].substring(0, cut1[z].length()-1);						
					} else {
						cutWon = cut1[z];
					}
					String[] cutComma = cutWon.split(",");
					String finalPrice = "";
					for(int j=0 ; j < cutComma.length ; j++) {
						finalPrice += cutComma[j];
					}
					int price = Integer.parseInt(finalPrice);				
					priceList.add(price);
				}
				
			} else {
				String cutWon = getPrice.substring(0, getPrice.length()-1);
				String[] cutComma = cutWon.split(",");
				String finalPrice = "";
				for(int j=0 ; j < cutComma.length ; j++) {
					finalPrice += cutComma[j];
				}
				int price = Integer.parseInt(finalPrice);				
				priceList.add(price);				
			}			
		}
		
		//합계 - 평균 금액 구하기
		for (int j=0 ; j < priceList.size() ; j++) {
			sumPrice += priceList.get(j);
		}
		if (priceList.size() != 0) {
			avgPrice = sumPrice / priceList.size();
		}		
		System.out.println("식당번호 : " + relNum + " ==> 가격계산  : 총 가격 : " + sumPrice + " / 갯수 : " + priceList.size() + " / 평균 가격 : " + avgPrice);
		return avgPrice;
	}

	@Override
	public Integer delteMEIsByRelNum(int relNum) {
		return meiMapper.delteMEIsByRelNum(relNum);
	}

	

}
