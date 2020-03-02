package com.kjk.nyam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kjk.nyam.config.FileUtil;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
//@PropertySource()
public class ImageTestController {

	@Resource
	private FileUtil fu;
	
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
	
	String uploadPath = "D:\\project\\nyamnyam_seoul\\back\\nyamnyam-seoul-back\\src\\main\\webapp\\resources\\upload\\"; // 동근이 데스크탑
//	String uploadPath = "E:\\study\\workspace\\nyamnyam-seoul\\src\\main\\webapp\\resources\\upload\\"; // 동근이 그램17
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
		sb.append("<script type='application/javascript'>window.parent.CKEDITOR.tools.callFunction(");
		sb.append(callback);
		sb.append(",'");
		sb.append(imgUrl);
		sb.append("','image upload success !!')</script>");
		System.out.println(sb.toString());
		
		StringBuffer ww = new StringBuffer();
		ww.append("<script type='text/javascript' crossorigin='anonymous'>alert('asdasd')</script>");
		return sb.toString();
//		return "success";
	}
	
	@PostMapping("/upload/one")
	public Map<String, Object> upload(MultipartFile upload) throws IllegalStateException, IOException{
		String reName = fu.fileUpload(upload, uploadPath + File.separator);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "http://localhost:809/image?name="+reName); //not null
		map.put("uploaded", 1); // allow null
		map.put("uploadedPercent", 1); // allow null
		map.put("error", "error"); // allow null
		return map;
	}
	
	@PostMapping("/upload/two")
	public @ResponseBody Map<String, Object> uploadImage(MultipartFile upload, @RequestHeader String host) {
		String path = uploadPath;
		String filePath = fu.fileUpload(upload, path);
		System.out.println(filePath);
		Map<String, Object> map = new HashMap<>();
		map.put("url", "http://" + host + "/image?name=" + filePath);
		return map;
	}
	
	@GetMapping("/image")
	public ResponseEntity<byte[]> image(@RequestParam(value="name") String name) throws IOException{
		File file = new File(uploadPath + File.separator + name);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
	}
}
