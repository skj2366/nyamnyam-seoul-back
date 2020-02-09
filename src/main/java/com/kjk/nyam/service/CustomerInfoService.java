package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.CustomerInfoVO;

public interface CustomerInfoService {

	public List<CustomerInfoVO> selectCUIList();
	public CustomerInfoVO selectCUIByEmail(String cui);
	public Integer selectCUIandCUCByEmail(String email);
	public Integer insertCUIOne(CustomerInfoVO cui);
	public Integer updateCUIOne(CustomerInfoVO cui);
	public Integer deleteCUIOne(int cuiNum);
}
