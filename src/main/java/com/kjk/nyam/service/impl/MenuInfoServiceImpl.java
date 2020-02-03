package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.MenuInfoMapper;
import com.kjk.nyam.service.MenuInfoService;
import com.kjk.nyam.vo.MenuInfoVO;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	@Resource
	private MenuInfoMapper meiMapper;
	
	@Override
	public List<MenuInfoVO> selectMEIList() {
		// TODO Auto-generated method stub
		return meiMapper.selectMEIList();
	}

}
