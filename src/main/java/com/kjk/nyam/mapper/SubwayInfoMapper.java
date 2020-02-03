package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.SubwayInfoVO;

@MapperScan
public interface SubwayInfoMapper {
	
	public List<SubwayInfoVO> selectSUIList();
}
