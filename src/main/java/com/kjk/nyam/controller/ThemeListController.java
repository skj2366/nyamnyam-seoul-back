package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.ThemeListService;
import com.kjk.nyam.vo.ThemeListVO;

@CrossOrigin("*")
@RestController 
public class ThemeListController {

	@Resource
	private ThemeListService thlService;
	
	@GetMapping("/thl")
	public List<ThemeListVO> selectTHLList() {
		return thlService.selectTHLList();
	}
	
	@PostMapping("/thl")
	public Integer insertTHLList(@RequestBody ThemeListVO thlVO) {
		System.out.println("테마 insert : " + thlVO);
		return thlService.insertTHLOne(thlVO);
	}
	
	@DeleteMapping("/thl/{relNum}")
	public Integer deleteThlOneByRelNum(@PathVariable("relNum") int relNum) {
		return thlService.deleteThlOneByRelNum(relNum);
	}
}
