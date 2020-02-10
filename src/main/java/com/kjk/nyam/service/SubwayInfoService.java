package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.SubwayInfoVO;

public interface SubwayInfoService {
	
	public List<SubwayInfoVO> selectSUIList();
	public List<SubwayInfoVO> selectSUIListByZone(int zoneNum);
}
