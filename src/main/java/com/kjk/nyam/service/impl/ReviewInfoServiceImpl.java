package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.ReviewInfoMapper;
import com.kjk.nyam.service.ReviewInfoService;
import com.kjk.nyam.vo.ReviewInfoVO;

@Service
public class ReviewInfoServiceImpl implements ReviewInfoService {

	@Resource
	private ReviewInfoMapper reiMapper;
	
	@Override
	public List<ReviewInfoVO> selectREIList() {
		return reiMapper.selectREIList();
	}

}
