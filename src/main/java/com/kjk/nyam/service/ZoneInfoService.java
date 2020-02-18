package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ZoneInfoVO;

public interface ZoneInfoService {
	
	public List<ZoneInfoVO> selectZOIList();
	public ZoneInfoVO selectZOIListByName(String zoneName);
}
