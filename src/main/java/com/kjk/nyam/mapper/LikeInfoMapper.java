package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.LikeInfoVO;

@MapperScan
public interface LikeInfoMapper {

	public List<LikeInfoVO> selectLIIList();
	public List<LikeInfoVO> selectLIIListByCuiNum(Integer cuiNum);
	public LikeInfoVO selectLIIByCuiNumAndRelNum(Integer cuiNum, Integer relNum);
	public Integer insertLIIOne(LikeInfoVO lii);
	public Integer deleteLIIOne(int liiNum);
}
