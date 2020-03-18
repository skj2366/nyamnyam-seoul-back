package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.LikeInfoVO;

public interface LikeInfoService {

	public List<LikeInfoVO> selectLIIList();
	public List<LikeInfoVO> selectLIIListByCuiNum(Integer cuiNum);
	public LikeInfoVO selectLIIByCuiNumAndRelNum(Integer cuiNum, Integer relNum);
	public Integer insertLIIOne(LikeInfoVO lii);

	public Integer deleteLIIOne(int liiNum);
	public Integer deleteLiisByRelNum(int relNum);

}
