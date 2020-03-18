package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.CustomerCertificationMapper;
import com.kjk.nyam.service.CustomerCertificationService;
import com.kjk.nyam.vo.CustomerCertificationVO;

@Service
public class CustomerCertificationServiceImpl implements CustomerCertificationService {

	@Resource
	private CustomerCertificationMapper cucMapper;
	
	@Override
	public List<CustomerCertificationVO> selectCUCList() {
		return cucMapper.selectCUCList();
	}

	@Override
	public CustomerCertificationVO selectCUCByEmail(String cucEmail) {
		System.out.println("인증 메일 서비스 : " + cucEmail);
		return cucMapper.selectCUCByEmail(cucEmail);
	}

	@Override
	public Integer insertCUCOne(CustomerCertificationVO cuc) {
		return cucMapper.insertCUCOne(cuc);
	}

	@Override
	public Integer deleteCUCOne(String cucEmail) {
		return cucMapper.deleteCUCOne(cucEmail);
	}

}
