package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.MenuInfoService;
import com.kjk.nyam.vo.MenuInfoVO;

@CrossOrigin("*")
@RestController
public class MenuInfoController {

	@Resource
	private MenuInfoService meiService;
	
	@GetMapping("/mei")
	public List<MenuInfoVO> selectMEIList() {
		return meiService.selectMEIList();
	}
	
	@PostMapping("/mei")
	public Integer insertMEIOne(@RequestBody MenuInfoVO mei) {
		return meiService.insertMEIOne(mei);
	}
	
	@PutMapping("/mei")
	public Integer updateMEIOne(@RequestBody MenuInfoVO mei) {
		return meiService.updateMEIOne(mei);
	}
	
	@DeleteMapping("/mei/{meiNum}")
	public Integer deleteMEIOne(@PathVariable("meiNum") int meiNum) {
		return meiService.deleteMEIOne(meiNum);
	}
}
