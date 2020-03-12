package com.kjk.nyam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("blog")
@Data
public class RestaurantBlogVO {

	private Integer blogNum;
	private Integer relNum;
	private String blogContentTitle;
	private String blogContentUrl;
	private String blogContentCredat;
	private String blogCredat;
	private String blogCretim;
}
