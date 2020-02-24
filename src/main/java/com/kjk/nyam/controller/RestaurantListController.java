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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.RestaurantListService;
import com.kjk.nyam.vo.RestaurantListVO;

@CrossOrigin("*")
@RestController
public class RestaurantListController {

	@Resource
	private RestaurantListService relService; 
	
	@GetMapping("/rel")
	public List<RestaurantListVO> selectRELList() {
		return relService.selectRELList();
	}
	
	@PostMapping("/rel")
	public Integer insertRELOne(@RequestBody RestaurantListVO rel) {
		return relService.insertRELOne(rel);
	}
	
	@PutMapping("/rel")
	public Integer updateRELOne(@RequestBody RestaurantListVO rel) {
		return relService.updateRELOne(rel);
	}
	
	@DeleteMapping("/rel/{relNum}")
	public Integer deleteRELOne(@PathVariable("relNum") int relNum) {
		return relService.deleteRELOne(relNum);
	}
	
	@GetMapping("/rel/{relCategory}")
	public List<RestaurantListVO> selectRELListByCategory(@PathVariable("relCategory") String relCategory) {
		return relService.selectRELListByCategory(relCategory);
	}
	
	@GetMapping("/rels")
	public List<RestaurantListVO> selectRELListWithZoneAndSubway(@RequestParam("zoneNum") Integer zoneNum, @RequestParam("subwayNum") Integer subwayNum) {
		System.out.println("zoneNum : " + zoneNum + " and subwayNum : " + subwayNum);
		return relService.selectRELListWithZoneAndSubway(zoneNum, subwayNum);
	}
	
	@GetMapping("/rels/thl")
	public List<RestaurantListVO> selectRELListWithTheme(@RequestParam("theme") String theme) {
		System.out.println("Controller theme : " + theme);
		return relService.selectRELListWithTheme(theme);
	}
}
