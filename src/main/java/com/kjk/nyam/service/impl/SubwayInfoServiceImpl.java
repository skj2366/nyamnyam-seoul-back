package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.SubwayInfoMapper;
import com.kjk.nyam.service.SubwayInfoService;
import com.kjk.nyam.vo.SubwayInfoVO;

@Service
public class SubwayInfoServiceImpl implements SubwayInfoService {

	@Resource
	private SubwayInfoMapper suiMapper;
	
	@Override
	public List<SubwayInfoVO> selectSUIList() {
		return suiMapper.selectSUIList();
	}

	@Override
	public List<SubwayInfoVO> selectSUIListByZone(int zoneNum) {
		return suiMapper.selectSUIListByZone(zoneNum);
	}

}
