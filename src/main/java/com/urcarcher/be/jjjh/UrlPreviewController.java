package com.urcarcher.be.jjjh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urcarcher.be.jjjh.dto.LinkPreviewDTO;

import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;

@CrossOrigin
@Log4j2
@RestController
@RequestMapping("/api/preview")
public class UrlPreviewController {
	
	@GetMapping("/url")
	public LinkPreviewDTO getUrlPreview(@RequestParam("url") String url) throws Exception {
        try {
        	
        	Document doc = Jsoup.parse(url);
        	// http://place.map.kakao.com/2040780653
        	// https://place.map.kakao.com/main/v/2040780653
        	// http://t1.daumcdn.net/place/7440664029DC46ABB5849413E1F011DF
            // Jsoup을 사용하여 HTML 문서를 가져옴
            //Document doc = Jsoup.connect(url).get();
            
            System.out.println(url);

            //System.out.println(doc);
            
            
            // 타이틀과 설명 추출 (추가 로직)
            String title = doc.title();
            String description = ""; 

            // bg_present 클래스를 가진 span 태그 선택
//            Element spanWithBackground = doc.selectFirst("span.bg_present");
//            String imageUrl = null;
//            if (spanWithBackground != null) {
//                String style = spanWithBackground.attr("style"); // style 속성 값 가져오기
//                log.info("Extracted style attribute: {}", style); 
//                imageUrl = extractBackgroundImageUrl(style); // background-image URL 추출
//                log.info("Extracted image URL: {}", imageUrl); 
//            }
//            
            // 원래 URL에서 중간에 /main/v/ 추가
            String jsonUrl = transformUrl(url);

            // JSON 데이터 추출
            String jsonResponse = fetchJsonFromUrl(jsonUrl);
            System.out.println(jsonResponse);
            // JSON 파싱 및 mainphotourl 추출
            String imageUrl = extractMainPhotoUrl(jsonResponse); //mainPhotoUrl


            return new LinkPreviewDTO(title, description, imageUrl, url);
            
    
        } catch (IOException e) {
            e.printStackTrace();
            return new LinkPreviewDTO("Failed to load", "", "", url);
        }
    }
	
	 // URL 변환 함수
    private String transformUrl(String originalUrl) {
        return originalUrl.replace(".com/", ".com/main/v/");
    }

    // JSON 데이터를 URL에서 가져오는 함수
    private String fetchJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        return content.toString();
    }

    // JSON에서 mainphotourl을 추출하는 함수
    private String extractMainPhotoUrl(String jsonResponse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);
        return rootNode.path("basicInfo").path("mainphotourl").asText();
    }

}
