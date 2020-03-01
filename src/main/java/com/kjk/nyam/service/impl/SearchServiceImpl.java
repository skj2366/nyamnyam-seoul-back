package com.kjk.nyam.service.impl;

import java.util.Arrays;
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
		int[] total = null;
		System.out.println("이건 타겠지?");
		int solo = 0;
		if(search.getSolo().equals(1)) {
			solo = search.getSolo();
		};
		int two = 0;
		if(search.getTwo().equals(1)) {
			two = search.getTwo();
		};
		int four = 0;
		if(search.getFour().equals(1)) {
			four = search.getFour();
		};
		System.out.println("@@@@@");
		if(solo == 1 && two == 1 && four == 1) {
			total = new int[3];
			total[0] = 1; total[1] = 2; total[2] = 3;
		}else if(solo == 1 && two == 0 && four == 0) {
			total = new int[1];
			total[0] = 1;
		}else if(solo == 0 && two == 1 && four == 0) {
			total = new int[1];
			total[0] = 2;
		}else if(solo == 0 && two == 0 && four == 1) {
			total = new int[1];
			total[0] = 3;
		}else if(solo == 1 && two == 1 && four == 0) {
			total = new int[2];
			total[0] = 1; total[1] = 2;
		}else if(solo == 1 && two == 0 && four == 1) {
			total = new int[2];
			total[0] = 1; total[1] = 3;
		}else if(solo == 0 && two == 1 && four == 1) {
			total = new int[2];
			total[0] = 2; total[1] = 3;
		}
		System.out.println("토탈을 보자 !");
		System.out.println(Arrays.toString(total));
		String arrString = Arrays.toString(total).replace("[", "");
		arrString = arrString.replace("]", "");
		System.out.println("arrString : " + arrString);
		if(arrString != null && arrString != "null") {
			System.out.println("이거");
			search.setTotal(arrString);
		}
		return searchMapper.search(search);
	}

}
