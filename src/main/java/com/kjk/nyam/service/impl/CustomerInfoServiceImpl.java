package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.auth.SHAEncoder;
import com.kjk.nyam.mapper.CustomerCertificationMapper;
import com.kjk.nyam.mapper.CustomerInfoMapper;
import com.kjk.nyam.service.CustomerInfoService;
import com.kjk.nyam.vo.CustomerInfoVO;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{

	@Resource
	private CustomerInfoMapper cuiMapper;
	
	@Resource
	private CustomerCertificationMapper cucMapper;
	
	@Override
	public List<CustomerInfoVO> selectCUIList() {
		return cuiMapper.selectCUIList();
	}

	@Override
	public Integer insertCUIOne(CustomerInfoVO cui) {
		if(cui.getCuiBirth().indexOf("-")!=-1) {
			cui.setCuiBirth(cui.getCuiBirth().replace("-", ""));
		}
		String pwd = cui.getCuiPwd();
		cui.setCuiPwd(SHAEncoder.encode(pwd));
		return cuiMapper.insertCUIOne(cui);
	}

	@Override
	public Integer updateCUIOne(CustomerInfoVO cui) {
		return cuiMapper.updateCUIOne(cui);
	}

	@Override
	public Integer deleteCUIOne(int cuiNum) {
		return cuiMapper.deleteCUIOne(cuiNum);
	}

	@Override
	public CustomerInfoVO selectCUIByEmail(String cui) {
		return cuiMapper.selectCUIByEmail(cui);
	}

}
