package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.ThemeListService;
import com.kjk.nyam.vo.ThemeListVO;

@RestController 
public class ThemeListController {

	@Resource
	private ThemeListService thlService;
	
	@GetMapping("/thl")
	public List<ThemeListVO> selectTHLList() {
		return thlService.selectTHLList();
	}
}
