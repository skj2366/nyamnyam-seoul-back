package com.kjk.nyam.service;

import java.util.List;

import com.kjk.nyam.vo.ThemeListVO;

public interface ThemeListService {

	public List<ThemeListVO> selectTHLList();
	public Integer insertTHLList(); // 사용 X
	public Integer insertTHLOne(ThemeListVO thlVO);
}
