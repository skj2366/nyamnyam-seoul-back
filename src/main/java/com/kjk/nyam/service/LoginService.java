package com.kjk.nyam.service;

import com.kjk.nyam.vo.CustomerInfoVO;

public interface LoginService {

	CustomerInfoVO doLogin(CustomerInfoVO cui);
}
