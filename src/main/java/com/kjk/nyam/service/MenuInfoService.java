package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.MenuInfoVO;

public interface MenuInfoService {

	public List<MenuInfoVO> selectMEIList();
	public List<MenuInfoVO> selectMEIListByRelNum(int relNum);
	public Integer averagePriceByRelNum(int relNum);
	
	public Integer insertMEIOne(MenuInfoVO mei);
	public Integer updateMEIOne(MenuInfoVO mei);
	
	public Integer deleteMEIOne(int meiNum);
	public Integer delteMEIsByRelNum(int relNum);

}
