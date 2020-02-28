package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.ReviewInfoVO;
import com.kjk.nyam.vo.SearchVO;

@MapperScan
public interface SearchMapper {

	public List<ReviewInfoVO> search(SearchVO search);
}
