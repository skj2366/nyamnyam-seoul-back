package com.kjk.nyam.config;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {
	
	private static final String BASE_PATH;
	static {
		String osName = System.getProperty("os.name");
		String comName = null;
		try {
			comName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(comName);
		if(comName!=null) {
			if(comName.equals("ES-DESKTOP-SLTKC5K")) {	//은송이
				BASE_PATH = "D:\\ES\\Documents\\project\\project02\\nyamnyam-seoul-back\\src\\main\\webapp\\resources\\upload\\";
			}else if(comName.equals("DESKTOP-3GG6G8D")){	// 금주
				BASE_PATH = "E:\\project-nyamnyam\\back-workspace\\git\\nyamnyam-seoul-back\\src\\main\\webapp\\resources\\upload\\";
			}else if(comName.equals("DESKTOP-1VRBG1H")){	// 동근 Gram
				BASE_PATH = "E:\\study\\workspace\\nyamnyam-seoul\\src\\main\\webapp\\resources\\upload\\";
			}else {	//동근 데스크탑 아직 널. 
				BASE_PATH = "";
			}
		}else if(osName.toLowerCase().indexOf("window")!=-1) {
			BASE_PATH = "";
		}else {
			BASE_PATH = "/upload/";
		}
	}

//	public String fileUpload(MultipartFile file,String filePath) {
//		String fileName = file.getOriginalFilename();
//		String extName = FilenameUtils.getExtension(fileName);
//		String reName= Long.toString(System.nanoTime());
//		reName += "." + extName;
//		File targetFile = new File(filePath+reName);
//		try {
//			Files.copy(file.getInputStream(), targetFile.toPath());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return reName;
//	}
	public String fileUpload(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String extName = FilenameUtils.getExtension(fileName);
		String reName= Long.toString(System.nanoTime());
		reName += "." + extName;
		File targetFile = new File(BASE_PATH + File.separator + reName);
		try {
			Files.copy(file.getInputStream(), targetFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reName;
	}
	
	public String returnBasePath() {
		return BASE_PATH;
	}
}
