package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.LikeInfoVO;

public interface LikeInfoService {

	public List<LikeInfoVO> selectLIIList();
	public Integer insertLIIOne(LikeInfoVO lii);
	public Integer deleteLIIOne(int liiNum);
}
