package com.kjk.nyam.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.kjk.nyam.vo.CustomerCertificationVO;

@MapperScan
public interface CustomerCertificationMapper {

	public List<CustomerCertificationVO> selectCUCList();
	public CustomerCertificationVO selectCUCByEmail(String cucEmail);
	public Integer insertCUCOne(CustomerCertificationVO cuc);
	public Integer deleteCUCOne(String cucEmail);
}
