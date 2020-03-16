package com.kjk.nyam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjk.nyam.service.LikeInfoService;
import com.kjk.nyam.vo.LikeInfoVO;

@CrossOrigin("*")
@RestController
public class LikeInfoController {

	@Resource
	private LikeInfoService liiService;
	
	@GetMapping("/lii")
	public List<LikeInfoVO> selectLIIList() {
		return liiService.selectLIIList();
	}
	
	@GetMapping("/liis/{cuiNum}")
	public List<LikeInfoVO> selectLIIListByCuiNum(@PathVariable("cuiNum") int cuiNum) {
		return liiService.selectLIIListByCuiNum(cuiNum);
	}
	
	@GetMapping("lii/{cuiNum}/{relNum}")
	public LikeInfoVO selectLIIByCuiNumAndRelNum(@PathVariable("cuiNum") Integer cuiNum, @PathVariable("relNum") Integer relNum) {
		System.out.println("cuiNum : " + cuiNum + " & relNum : " + relNum);
		return liiService.selectLIIByCuiNumAndRelNum(cuiNum, relNum);
	}
	
	@PostMapping("/lii")
	public Integer insertLIIOne(@RequestBody LikeInfoVO lii) {
		return liiService.insertLIIOne(lii);
	}
	
	@DeleteMapping("/lii/{liiNum}")
	public Integer deleteLIIOne(@PathVariable("liiNum") int liiNum) {
		return liiService.deleteLIIOne(liiNum);
	}
}
