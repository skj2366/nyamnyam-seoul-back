package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.auth.SHAEncoder;
import com.kjk.nyam.mapper.CustomerCertificationMapper;
import com.kjk.nyam.mapper.CustomerInfoMapper;
import com.kjk.nyam.service.CustomerInfoService;
import com.kjk.nyam.vo.CustomerCertificationVO;
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

	@Override
	public Integer selectCUIandCUCByEmail(String email) {
		CustomerInfoVO cui = new CustomerInfoVO();
		CustomerCertificationVO cuc = new CustomerCertificationVO();
		
		try {
			System.out.println("일단 여기까지");
			cui = cuiMapper.selectCUIByEmail(email);
		} catch (Exception e) {

		}

		if( cui != null ) {
			System.out.println("이미 가입된 메일 입니다.");
			return 0;
		}else {
			cuc = cucMapper.selectCUCByEmail(email);
			if(cuc != null) {
				System.out.println("가입되지 않은 메일이지만 메일 발송 이력 있고 24시간이 지나지 않아 데이터가 살아 있음");
				return 1;
			}else {
				System.out.println("가입되지 않은 메일, 메일 발송 이력 없음");
				return 2;
			}
		}
	}

}
