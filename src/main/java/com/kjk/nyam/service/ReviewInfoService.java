package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ReviewInfoVO;

public interface ReviewInfoService {

	public List<ReviewInfoVO> selectREIList();
	public ReviewInfoVO selectREIOne(int reiNum);
	public List<ReviewInfoVO> selectREIListByCuiNum(int cuiNum);
	public List<ReviewInfoVO> selectREIListByRelNum(int relNum);
	
	public Integer insertREIOne(ReviewInfoVO rei);
	public Integer updateREIOne(ReviewInfoVO rei);
	public Integer deleteREIOne(int reiNum);
	public Integer deleteReisByRelNum(int relNum);
	
	public List<ReviewInfoVO> selectREIListForReview();
	public Integer updateREICount(int reiNum);
	
	public Integer insertImage();
	
}
