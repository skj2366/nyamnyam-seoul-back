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

	@Override
	public List<CommentInfoVO> selectCOIListByCuiNum(int cuiNum) {
		return coiMapper.selectCOIListByCuiNum(cuiNum);
	}
	
	@Override
	public Integer insertCOIOne(CommentInfoVO coi) {
		return coiMapper.insertCOIOne(coi);
	}	

	@Override
	public List<CommentInfoVO> selectCOIListByReiNum(int reiNum) {
		return coiMapper.selectCOIListByReiNum(reiNum);
	}

	@Override
	public Integer updateCOIOne(CommentInfoVO coi) {
		return coiMapper.updateCOIOne(coi);
	}
	
	@Override
	public Integer deleteCOIOne(int coiNum) {
		return coiMapper.deleteCOIOne(coiNum);
	}

	@Override
	public Integer deleteCoisByReiNum(int reiNum) {
		return coiMapper.deleteCOIOne(reiNum);
	}	

}
