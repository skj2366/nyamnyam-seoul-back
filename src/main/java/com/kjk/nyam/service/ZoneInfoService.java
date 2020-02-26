package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ZoneInfoVO;

public interface ZoneInfoService {
	
	public List<ZoneInfoVO> selectZOIList();
	public ZoneInfoVO selectZOIOneByName(String zoneName);
	public ZoneInfoVO selectZOIOneByNum(Integer zoneNum);
}
