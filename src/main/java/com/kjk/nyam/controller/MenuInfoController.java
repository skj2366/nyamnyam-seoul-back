package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.impl.MenuInfoServiceImpl;
import com.kjk.nyam.vo.MenuInfoVO;

@RestController
public class MenuInfoController {

	@Resource
	private MenuInfoServiceImpl meiService;
	
	@GetMapping("/mei")
	public List<MenuInfoVO> selectMEIList() {
		return meiService.selectMEIList();
	}
}
