package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.ThemeListVO;

@MapperScan
public interface ThemeListMapper {

	public List<ThemeListVO> selectTHLList();
	public Integer insertTHLList(ThemeListVO thlVO);
}
