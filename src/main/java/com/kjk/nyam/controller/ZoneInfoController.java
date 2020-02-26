package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.ZoneInfoService;
import com.kjk.nyam.vo.ZoneInfoVO;

@CrossOrigin("*")
@RestController
public class ZoneInfoController {

	@Resource
	private ZoneInfoService zoiService;
	
	@GetMapping("/zoi")
	public List<ZoneInfoVO> selectZOIList() {
		return zoiService.selectZOIList();
	}
	
	@GetMapping("/zoina/{zoneName}")
	public ZoneInfoVO selectZOIOneByName(@PathVariable("zoneName") String zoneName) {
		return zoiService.selectZOIOneByName(zoneName);
	}
	
	@GetMapping("/zoinu/{zoneNum}")
	public ZoneInfoVO selectZOIOneByNum(@PathVariable("zoneNum") int zoneNum) {
		return zoiService.selectZOIOneByNum(zoneNum);
	}
}
