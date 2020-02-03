package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.LikeInfoService;
import com.kjk.nyam.vo.LikeInfoVO;

@RestController
public class LikeInfoController {

	@Resource
	private LikeInfoService liiService;
	
	@GetMapping("/lii")
	public List<LikeInfoVO> selectLIIList() {
		return liiService.selectLIIList();
	}
}
