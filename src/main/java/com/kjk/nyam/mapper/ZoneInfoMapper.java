package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.ZoneInfoVO;

@MapperScan
public interface ZoneInfoMapper {
	
	public List<ZoneInfoVO> selectZOIList();
	public ZoneInfoVO selectZOIOneByName(String zoneName);
	public ZoneInfoVO selectZOIOneByNum(Integer zoneNum);
}
