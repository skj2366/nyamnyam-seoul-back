package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.ZoneInfoMapper;
import com.kjk.nyam.service.ZoneInfoService;
import com.kjk.nyam.vo.ZoneInfoVO;

@Service
public class ZoneInfoServiceImple implements ZoneInfoService {

	@Resource
	private ZoneInfoMapper zoiMapper;
	
	@Override
	public List<ZoneInfoVO> selectZOIList() {
		return zoiMapper.selectZOIList();
	}

}
