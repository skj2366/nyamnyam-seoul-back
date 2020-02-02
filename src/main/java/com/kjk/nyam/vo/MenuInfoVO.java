package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("mei")
@Data
public class MenuInfoVO {

	private Integer meiNum;
	private Integer relNum;
	private String meiName;
	private Integer meiPrice;
	private String meiImg1;
	private String meiImg2;
	private String meiImg3;
	private String meiCredat;
	private String meiCretim;
	private String meiModdat;
	private String meiModtim;
}
