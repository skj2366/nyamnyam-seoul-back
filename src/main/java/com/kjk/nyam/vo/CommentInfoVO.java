package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("coi")
@Data
public class CommentInfoVO {

	private Integer coiNum;
	private Integer subNum;
	private String coiContents;
	private String coiCredat;
	private String coiCretim;
	
	private Integer cuiNum; //FK_유저
	private Integer reiNum; //FK_후기
	
}
