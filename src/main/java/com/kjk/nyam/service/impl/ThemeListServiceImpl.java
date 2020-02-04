package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.ThemeListMapper;
import com.kjk.nyam.service.ThemeListService;
import com.kjk.nyam.vo.ThemeListVO;

@Service
public class ThemeListServiceImpl implements ThemeListService {

	@Resource
	private ThemeListMapper thlMapper;
	
	@Override
	public List<ThemeListVO> selectTHLList() {
		return thlMapper.selectTHLList();
	}

}
