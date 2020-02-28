package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.SearchMapper;
import com.kjk.nyam.service.SearchService;
import com.kjk.nyam.vo.ReviewInfoVO;
import com.kjk.nyam.vo.SearchVO;

@Service
public class SearchServiceImpl implements SearchService {

	@Resource
	private SearchMapper searchMapper;
	
	@Override
	public List<ReviewInfoVO> search(SearchVO search) {
		System.out.println("Service : " + search);
		return searchMapper.search(search);
	}

}
