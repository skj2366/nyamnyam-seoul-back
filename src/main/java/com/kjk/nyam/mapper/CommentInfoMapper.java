package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.CommentInfoVO;

@MapperScan
public interface CommentInfoMapper {

	public List<CommentInfoVO> selectCOIList();
	public List<CommentInfoVO> selectCOIListByCuiNum(int cuiNum);
	public Integer insertCOIOne(CommentInfoVO coi);
	public Integer deleteCOIOne(int coiNum);
	public List<CommentInfoVO> selectCOIListByReiNum(int reiNum);
}
