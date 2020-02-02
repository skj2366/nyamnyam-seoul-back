package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Alias("mei")
@Data
public class MenuInfoVO {

	private Integer meiNum;
	private Integer relNum;
	private String meiName;
	private Integer meiPrice;
	private MultipartFile meiImg1;
	private String meiImg1Name;
	private MultipartFile meiImg2;
	private String meiImg2Name;
	private MultipartFile meiImg3;
	private String meiImg3Name;
	private String meiCredat;
	private String meiCretim;
	private String meiModdat;
	private String meiModtim;
}
