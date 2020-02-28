package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.SearchService;
import com.kjk.nyam.vo.ReviewInfoVO;
import com.kjk.nyam.vo.SearchVO;

@CrossOrigin("*")
@RestController
public class SearchController {

	@Resource
	private SearchService searchService;
	
	@GetMapping("/search")
	public List<ReviewInfoVO> search(SearchVO search) {
		System.out.println(search);
		return searchService.search(search);
	}
}
