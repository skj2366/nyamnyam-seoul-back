package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.MenuInfoVO;

@MapperScan
public interface MenuInfoMapper {
	
	public List<MenuInfoVO> selectMEIList();
}
