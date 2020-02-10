package com.kjk.nyam.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("cui")
@Data
public class CustomerInfoVO {

	@NotNull
	private Integer cuiNum;
	private String cuiId;
	private String cuiPwd;
	private String cuiName;
	private String cuiNickname;
	private String cuiBirth;
	private String cuiEmail;
	private String cuiPhone;
	private String cuiTrans;
	private String cuiGrade;
	private String cuiCredat;
	private String cuiCretim;
	private String cuiModdat;
	private String cuiModtim;
	
	private String tokken;
}
