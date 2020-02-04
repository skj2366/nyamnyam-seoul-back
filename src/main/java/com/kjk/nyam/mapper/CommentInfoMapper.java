package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.CommentInfoVO;

@MapperScan
public interface CommentInfoMapper {

	public List<CommentInfoVO> selectCOIList();
}
