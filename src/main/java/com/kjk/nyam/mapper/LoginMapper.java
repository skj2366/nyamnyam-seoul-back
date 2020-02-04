package com.kjk.nyam.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.CustomerInfoVO;

@MapperScan
public interface LoginMapper {
	CustomerInfoVO selectForCUI(CustomerInfoVO cui);
}
