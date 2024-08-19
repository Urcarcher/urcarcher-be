package com.urcarcher.be.jjjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urcarcher.be.jjjh.entity.StoreDBTestTable;
import com.urcarcher.be.jjjh.repository.StoreRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StoreService {

	@Autowired
    private StoreRepository storeRepository;

    public void saveStoreData(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);

            JsonNode documents = root.get("documents");
            if (documents.isArray()) {
                for (JsonNode doc : documents) {
                	//JSON에서 필요한 데이터 추출
                	String store_id = doc.get("id").asText();
                    String store_name = doc.get("place_name").asText();  
                    String store_addr = doc.get("address_name").asText();  
                    String store_road_addr = doc.get("road_address_name").asText(); 
                    String store_phone = doc.get("phone").asText(); 
                    String store_url = doc.get("place_url").asText();  
                    String category_code = doc.get("category_group_code").asText();  
                    String category_name = doc.get("category_group_name").asText(); 
                    String store_x = doc.get("x").asText(); 
                    String store_y = doc.get("y").asText(); 

                    // Store 엔티티 생성 (순서 중요)
                    StoreDBTestTable store = new StoreDBTestTable(store_id, store_name, store_phone,store_addr, store_road_addr , store_url,store_x,store_y, category_code, category_name);
                    
                    // Store 엔티티를 데이터베이스에 저장
                    storeRepository.save(store);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
