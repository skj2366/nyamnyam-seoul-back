package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.CustomerInfoMapper;
import com.kjk.nyam.service.CustomerInfoService;
import com.kjk.nyam.vo.CustomerInfoVO;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{

	@Resource
	private CustomerInfoMapper cuiMapper;
	
	@Override
	public List<CustomerInfoVO> selectCUIList() {
		return cuiMapper.selectCUIList();
	}

}
