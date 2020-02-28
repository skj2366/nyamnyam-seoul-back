package com.kjk.nyam.crawling;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.WebAnnotationSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingImgService {

	private static String SAVE_PATH = "D:\\ES\\Documents\\project\\project02\\image\\";
	private static String SAVE_FILE_NAME = "";
	
	public static List<String> readFile() {
		int n;		
		String[] urls;
		List<String> urlList = new ArrayList<String>();
		BufferedReader bure = null;
		
		try {
			bure = new BufferedReader(new FileReader("urlid.txt"));
			String str = "";
			while((str = bure.readLine()) != null) {
				urls = str.split(" ");
				urlList.add(urls[3]);
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlList;
	}
	
	public static Integer imageCrawling() {
		int count = 0;
		String fileFormat = "jpg";
		URL url = null;
		BufferedImage bi = null;
		
		List<String> urlList = new ArrayList<>();
		urlList = readFile();
		
		try {
			for(int i=0 ; i < 3 ; i++) {				
				Document document = Jsoup.connect(urlList.get(i)).get();
				System.out.println(urlList.get(i));
							
				Elements elements = document.select("");
				String imgText = elements.text();
				System.out.println("==> " + imgText);				
			}
							
						
//			File saveFile = new File(SAVE_PATH + SAVE_FILE_NAME);
//			
//			url = new URL(src);
//			bi = ImageIO.read(url);
//			ImageIO.write(bi, fileFormat, saveFile);			
//			
//			count += 1;			
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}		
		return count;
	}
	
	
	public static void main(String[] args) {		
		imageCrawling();		
	}

}
