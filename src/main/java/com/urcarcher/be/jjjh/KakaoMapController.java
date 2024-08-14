package com.urcarcher.be.jjjh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.urcarcher.be.jjjh.service.KakaoMapService;
import com.urcarcher.be.jjjh.service.StoreService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/kakaomap")
public class KakaoMapController {
	 @Autowired
	 private KakaoMapService kakaoMapService;
	 @Autowired
    private StoreService storeService;
	 
	 @GetMapping(value = "/search", produces = "application/json;charset=UTF-8")
	 public ResponseEntity<JsonNode> searchAddress(@RequestParam("keyword") String keyword) {
	    
		 System.out.println("Received keyword: " + keyword); 
	   
		 //결과
	    JsonNode result = kakaoMapService.searchPlaceByKeyword(keyword);
	    if (result != null) {
	    	
	    	// 검색 결과를 가맹점 DB에 저장
	    	//https://urcarcher-local.kro.kr:8443/api/kakaomap/search?keyword=여기에키워드작성(검색과 동시에 insert됨)
            //storeService.saveStoreData(result.toString());

            return ResponseEntity.ok(result);
	    } else {
	        return ResponseEntity.status(500).body(null);
	    }
	 }
	 
  
}
