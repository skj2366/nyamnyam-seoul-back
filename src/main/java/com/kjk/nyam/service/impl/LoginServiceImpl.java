package com.kjk.nyam.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.auth.SHAEncoder;
import com.kjk.nyam.mapper.LoginMapper;
import com.kjk.nyam.service.LoginService;
import com.kjk.nyam.vo.CustomerInfoVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginMapper loginMapper;
	
	public CustomerInfoVO doLogin(CustomerInfoVO cui) {
//		if(cui.getCuiPwd()==null || cui.getCuiPwd().isEmpty()) {
//			throw new ServiceException("비밀번호를 확인해주세요.");
//		}
		if(cui.getCuiPwd()!=null) {
			cui.setCuiPwd(SHAEncoder.encode(cui.getCuiPwd()));
		}
		return loginMapper.selectForCUI(cui);
	}
}
