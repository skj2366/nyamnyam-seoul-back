package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.LikeInfoMapper;
import com.kjk.nyam.service.LikeInfoService;
import com.kjk.nyam.vo.LikeInfoVO;

@Service
public class LikeInfoServiceImpl implements LikeInfoService {

	@Resource
	private LikeInfoMapper liiMapper;
	
	@Override
	public List<LikeInfoVO> selectLIIList() {
		return liiMapper.selectLIIList();
	}
	
	@Override
	public List<LikeInfoVO> selectLIIListByCuiNum(Integer cuiNum) {
		return liiMapper.selectLIIListByCuiNum(cuiNum);
	}

	@Override
	public Integer insertLIIOne(LikeInfoVO lii) {
		return liiMapper.insertLIIOne(lii);
	}

	@Override
	public Integer deleteLIIOne(int liiNum) {
		return liiMapper.deleteLIIOne(liiNum);
	}

	

}
