package com.kjk.nyam.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kjk.nyam.mapper.CommentInfoMapper;
import com.kjk.nyam.mapper.ReviewInfoMapper;
import com.kjk.nyam.service.ReviewInfoService;
import com.kjk.nyam.vo.ReviewInfoVO;

@Service
public class ReviewInfoServiceImpl implements ReviewInfoService {

	static final String BASE_PATH = "";
	
	@Resource
	private ReviewInfoMapper reiMapper;
	
	@Resource
	private CommentInfoMapper coiMapper;
	
	@Override
	public List<ReviewInfoVO> selectREIList() {
		return reiMapper.selectREIList();
	}

	@Override
	public ReviewInfoVO selectREIOne(int reiNum) {
		return reiMapper.selectREIOne(reiNum);
	}
	
	@Override
	public List<ReviewInfoVO> selectREIListByCuiNum(int cuiNum) {
		return reiMapper.selectREIListByCuiNum(cuiNum);
	}
	
	@Override
	public List<ReviewInfoVO> selectREIListByRelNum(int relNum) {
		return reiMapper.selectREIListByRelNum(relNum);
	}
	
	@Override
	public Integer insertREIOne(ReviewInfoVO rei) {
		if(rei.getReiDate().indexOf("-")!=-1) {
			rei.setReiDate(rei.getReiDate().replace("-", ""));
		}
		
		if(rei.getReiImg1()!=null) {
			MultipartFile mf1 = rei.getReiImg1();
			String originName1 = mf1.getOriginalFilename();
			String extName1 = "";			
			if(originName1.lastIndexOf(".")!=-1) {
				extName1 = originName1.substring(originName1.lastIndexOf("."));
			}			
			String fileName1 = System.currentTimeMillis() + extName1;
			File saveFile1 = new File(BASE_PATH + fileName1);
			
			try {
				Files.copy(mf1.getInputStream(), saveFile1.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rei.setReiImg1Name("/imgs/"+fileName1);
		}		
			
		
		return reiMapper.insertREIOne(rei);
	}

	@Override
	public Integer updateREIOne(ReviewInfoVO rei) {
		return reiMapper.updateREIOne(rei);
	}

	@Override
	public Integer deleteREIOne(int reiNum) {
		//리뷰 지우면 댓글 사라지게
		coiMapper.deleteCoisByReiNum(reiNum);
		return reiMapper.deleteREIOne(reiNum);
	}
	
	@Override
	public Integer deleteReisByRelNum(int relNum) {
		int count = 0;
		List<ReviewInfoVO> reviews = reiMapper.selectREIListByRelNum(relNum);
		for(int i=0 ; i<reviews.size() ; i++) {
			coiMapper.deleteCoisByReiNum(reviews.get(i).getReiNum());
			count++;
			System.out.println("리뷰 연관 댓글 " + count + "개 삭제");
		}		
		return reiMapper.deleteReisByRelNum(relNum);
	}

	@Override
	public List<ReviewInfoVO> selectREIListForReview() {
		return reiMapper.selectREIListForReview();
	}

	@Override
	public Integer updateREICount(int reiNum) {
		//System.out.println("카운트 1 증가 서비스");
		return reiMapper.updateREICount(reiNum);
	}
	
	@Override
	public Integer insertImage() {
		return null;
	}


}
