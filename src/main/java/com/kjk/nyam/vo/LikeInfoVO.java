package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("lii")
@Data
public class LikeInfoVO {

	private Integer liiNum;
	private Integer cuiNum;
	private Integer relNum;
	private String liiCredat;
	private String liiCretim;
}
