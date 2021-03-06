package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.SubwayInfoService;
import com.kjk.nyam.vo.SubwayInfoVO;

@CrossOrigin("*")
@RestController
public class SubwayInfoController {

	@Resource
	private SubwayInfoService suiService;
	
	@GetMapping("/sui")
	public List<SubwayInfoVO> selectSUIList() {
		return suiService.selectSUIList();
	}	
	
	@GetMapping("/sui/{zoneNum}")
	public List<SubwayInfoVO> selectSUIListByZone(@PathVariable("zoneNum") int zoneNum){
		return suiService.selectSUIListByZone(zoneNum);
	}
}
