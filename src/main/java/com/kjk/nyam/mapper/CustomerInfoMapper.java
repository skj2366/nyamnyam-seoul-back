package com.kjk.nyam.mapper;

import org.mybatis.spring.annotation.MapperScan;
import java.util.List;
import com.kjk.nyam.vo.CustomerInfoVO;

@MapperScan
public interface CustomerInfoMapper {

	public List<CustomerInfoVO> selectCUIList();
	public CustomerInfoVO selectCUIByEmail(String cui);
	public Integer insertCUIOne(CustomerInfoVO cui);
	public Integer updateCUIOne(CustomerInfoVO cui);
	public Integer deleteCUIOne(int cuiNum);
}
