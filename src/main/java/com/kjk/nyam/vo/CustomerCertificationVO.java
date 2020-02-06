package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("cuc")
@Data
public class CustomerCertificationVO {

	private Integer cucNum;
	private String cucEmail;
	private String cucCerNum;
	private String cucCredat;
	private String cucCretim;
}
