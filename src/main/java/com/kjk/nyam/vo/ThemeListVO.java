package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("thl")
@Data
public class ThemeListVO {
	
	private Integer thlNum;
	private Integer relNum;
	private Integer thlSolo;
	private Integer thlCouple;
	private Integer thlFour;
	private String thlCredat;
	private String thlCretim;
	private String thlModdat;
	private String thlModtim;

}
