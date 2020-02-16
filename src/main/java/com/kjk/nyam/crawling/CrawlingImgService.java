package com.kjk.nyam.crawling;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingImgService {

	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect("https://store.naver.com/restaurants/detail?id=83612604").get();
			String folder = document.title();
			Element element = document.select(".top_photo_area").get(0);
			Elements img = element.select("img");
			
			int page = 0;
			
			for(Element e : img) {
				String url = e.getElementsByAttribute("src").attr("src");
				
				URL imgUrl = new URL(url);
				BufferedImage jpg = ImageIO.read(imgUrl);
				File file = new File("경로" + folder + "\\" + page + ".jpg");
				ImageIO.write(jpg, "jpg", file);
				page += 1;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 *  Document doc = Jsoup.connect("URL 주소").get();
        String folder = doc.title();
        Element element = doc.select("이미지들이 포함된 선택자").get(0);
        Elements img = element.select("img");
        int page = 0;
        for (Element e : img) {
            String url = e.getElementsByAttribute("src").attr("src");
            
            URL imgUrl = new URL(url);
            
            HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
            System.out.println(conn.getContentLength());
            
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream os = new FileOutputStream("경로\\"+folder+"\\"+page+".jpg");
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int byteImg;
            
            byte[] buf = new byte[conn.getContentLength()];
            while((byteImg = bis.read(buf)) != -1) {
                bos.write(buf,0,byteImg);
            }
            page += 1;
 
            bos.close();
            os.close();
            bis.close();
            is.close();
            
        }

		 */
	}

}
