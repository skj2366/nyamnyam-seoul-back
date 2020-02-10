package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ReviewInfoVO;

public interface ReviewInfoService {

	public List<ReviewInfoVO> selectREIList();
	public ReviewInfoVO selectREIOne(int reiNum);
	
	public Integer insertREIOne(ReviewInfoVO rei);
	public Integer updateREIOne(ReviewInfoVO rei);
	public Integer deleteREIOne(int reiNum);
}
