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

	@Override
	public ReviewInfoVO selectREIOne(int reiNum) {
		return reiMapper.selectREIOne(reiNum);
	}
	
	@Override
	public Integer insertREIOne(ReviewInfoVO rei) {
		return reiMapper.insertREIOne(rei);
	}

	@Override
	public Integer updateREIOne(ReviewInfoVO rei) {
		return reiMapper.updateREIOne(rei);
	}

	@Override
	public Integer deleteREIOne(int reiNum) {
		ReviewInfoVO reivo = reiMapper.selectREIOne(reiNum);
		if(reiMapper.deleteREIOne(reiNum)==1) {
			return 0;
		}
		return 0;
	}

}
