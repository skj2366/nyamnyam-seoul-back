package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.CommentInfoService;
import com.kjk.nyam.vo.CommentInfoVO;

@RestController
public class CommentInfoController {

	@Resource
	private CommentInfoService coiService;
	
	@GetMapping("/coi")
	public List<CommentInfoVO> selectCOIList() {
		return coiService.selectCOIList();
	}
}
