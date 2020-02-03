package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.SubwayInfoService;
import com.kjk.nyam.vo.SubwayInfoVO;

@RestController
public class SubwayInfoController {

	@Resource
	private SubwayInfoService suiService;
	
	@GetMapping("/sui")
	public List<SubwayInfoVO> selectSUIList() {
		return suiService.selectSUIList();
	}
}
