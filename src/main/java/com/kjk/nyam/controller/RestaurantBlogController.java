package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.RestaurantBlogService;
import com.kjk.nyam.vo.RestaurantBlogVO;

@CrossOrigin("*")
@RestController
public class RestaurantBlogController {

	@Resource
	private RestaurantBlogService rebService;
	
	@GetMapping("/blog/{relNum}")
	public List<RestaurantBlogVO> selectBlogList(@PathVariable("relNum") Integer relNum){
		return rebService.selectBlogListByRelNum(relNum);
	}
	
	@DeleteMapping("/blogs/{relNum}")
	public Integer deleteBlogsByRelNum(@PathVariable("relNum") Integer relNum) {
		return rebService.deleteBlogsByRelNum(relNum);
	}
}
