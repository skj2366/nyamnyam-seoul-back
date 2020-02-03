package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.ZoneInfoService;
import com.kjk.nyam.vo.ZoneInfoVO;

@RestController
public class ZoneInfoController {

	@Resource
	private ZoneInfoService zoiService;
	
	@GetMapping("/zoi")
	public List<ZoneInfoVO> selectZOIList() {
		return zoiService.selectZOIList();
	}
}
