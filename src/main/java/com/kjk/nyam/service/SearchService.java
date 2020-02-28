package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ReviewInfoVO;
import com.kjk.nyam.vo.SearchVO;

public interface SearchService {

	public List<ReviewInfoVO> search(SearchVO search);
}
