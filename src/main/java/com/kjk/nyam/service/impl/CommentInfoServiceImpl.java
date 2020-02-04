package com.kjk.nyam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjk.nyam.mapper.CommentInfoMapper;
import com.kjk.nyam.service.CommentInfoService;
import com.kjk.nyam.vo.CommentInfoVO;

@Service
public class CommentInfoServiceImpl implements CommentInfoService {

	@Resource
	private CommentInfoMapper coiMapper;
	
	@Override
	public List<CommentInfoVO> selectCOIList() {
		return coiMapper.selectCOIList();
	}

}
