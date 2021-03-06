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
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.CommentInfoService;
import com.kjk.nyam.vo.CommentInfoVO;

@CrossOrigin("*")
@RestController
public class CommentInfoController {

	@Resource
	private CommentInfoService coiService;
	
	@GetMapping("/coi")
	public List<CommentInfoVO> selectCOIList() {
		return coiService.selectCOIList();
	}
	
	@GetMapping("/coi/{cuiNum}")
	public List<CommentInfoVO> selectCOIListByCuiNum(@PathVariable("cuiNum") int cuiNum) {
		// 고객별 마이페이지에서 자기가 쓴 댓글 확인
		return coiService.selectCOIListByCuiNum(cuiNum);
	}
	
	@GetMapping("/coi/rei/{reiNum}")
	public List<CommentInfoVO> selectCOIListByReiNum(@PathVariable("reiNum") int reiNum) {
		// 후기를 위한 댓글 리스트
		return coiService.selectCOIListByReiNum(reiNum);
	}
	
	@PostMapping("/coi")
	public Integer insertPOIOne(@RequestBody CommentInfoVO coi) {
		return coiService.insertCOIOne(coi);
	}
	
	@PutMapping("/coi/{coiNum}")
	public Integer updateCOIOne(@RequestBody CommentInfoVO coi) {
		return coiService.updateCOIOne(coi);
	}
	
	@DeleteMapping("/coi/{coiNum}")
	public Integer deleteCOIOne(@PathVariable("coiNum") int coiNum) {
		return coiService.deleteCOIOne(coiNum);
	}
}
