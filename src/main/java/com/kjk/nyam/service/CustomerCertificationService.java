package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.CustomerCertificationVO;

public interface CustomerCertificationService {

	public List<CustomerCertificationVO> selectCUCList();
	public CustomerCertificationVO selectCUCByEmail(CustomerCertificationVO cuc);
	public Integer insertCUCOne(CustomerCertificationVO cuc);
	public Integer deleteCUCOne(String cucEmail);
}
