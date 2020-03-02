package com.kjk.nyam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
//@PropertySource()
public class ImageTestController {

	@PostMapping("/it")
	public Integer insertImage(@RequestParam MultipartFile upload) {
		String fileName = upload.getOriginalFilename();
		try {
			byte[] bytes = upload.getBytes();
			String uploadPath = "D:\\project\\nyamnyam_seoul\\back\\nyamnyam-seoul-back\\src\\main\\resources\\img\\";
			OutputStream out = new FileOutputStream(new File(uploadPath + fileName));
			out.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
//	@Value("${image.upload.path}")
//	String uploadPath;
//	@Value("${image.upload.uri}")
//	String uploadUri;
	
	String uploadPath = "D:\\project\\nyamnyam_seoul\\back\\nyamnyam-seoul-back\\src\\main\\webapp\\resources\\upload\\";
	String uploadUri = "/resources/upload/";
	
	@PostMapping("/image/upload")
	@SneakyThrows
	public String upload(@RequestPart MultipartFile upload, @RequestParam("CKEditorFuncNum") String callback, HttpServletRequest request) {
		String sourceName = upload.getOriginalFilename();
		System.out.println(sourceName);
		String sourceExt = FilenameUtils.getExtension(sourceName).toLowerCase();
		System.out.println(sourceExt);
		File destFile;
		String destFileName;
		
		do {
			destFileName = RandomStringUtils.randomAlphabetic(8).concat(".").concat(sourceExt);
			System.out.println(destFileName);
			destFile = new File(uploadPath.concat(destFileName));
			System.out.println(uploadPath);
		}while (destFile.exists());
		destFile.getParentFile().mkdirs();
		upload.transferTo(destFile);
		
		String imgUrl = request.getScheme().concat("://").concat(request.getServerName() + ":809").concat(uploadUri).concat(destFileName);
		System.out.println(imgUrl);
		// ckeditor upload callback
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(");
		sb.append(callback);
		sb.append(",'");
		sb.append(imgUrl);
		sb.append("','image upload success !!')</script>");
		System.out.println(sb.toString());
		
		StringBuffer ww = new StringBuffer();
		ww.append("<script type='text/javascript'>alert('asdasd')</script>");
		return sb.toString();
	}
}
