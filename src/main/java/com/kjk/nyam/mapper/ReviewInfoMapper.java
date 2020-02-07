package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.ReviewInfoVO;

@MapperScan
public interface ReviewInfoMapper {

	public List<ReviewInfoVO> selectREIList();
	public Integer insertREIOne(ReviewInfoVO rei);
	public Integer updateREIOne(ReviewInfoVO rei);
	public Integer deleteREIOne(int reiNum);
}
