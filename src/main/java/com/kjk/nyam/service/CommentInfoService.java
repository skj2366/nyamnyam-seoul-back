package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.CommentInfoVO;

public interface CommentInfoService {

	public List<CommentInfoVO> selectCOIList();
	public List<CommentInfoVO> selectCOIListByCuiNum(int cuiNum);

	public Integer insertCOIOne(CommentInfoVO coi);	
	public Integer updateCOIOne(CommentInfoVO coi);
	public Integer deleteCOIOne(int coiNum);

	public Integer deleteCoisByReiNum(int reiNum);
	
	public List<CommentInfoVO> selectCOIListByReiNum(int reiNum);
}
