package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.CustomerInfoVO;

@MapperScan
public interface CustomerInfoMapper {

	public List<CustomerInfoVO> selectCUIList();
}
