package com.urcarcher.be.jjjh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urcarcher.be.jjjh.dto.StoreCategoryDTO;
import com.urcarcher.be.jjjh.dto.StoreDTO;
import com.urcarcher.be.jjjh.dto.StoreWithCountDTO;
import com.urcarcher.be.jjjh.entity.StoreEntity;
import com.urcarcher.be.jjjh.repository.StoreRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StoreService {

	@Autowired
    private StoreRepository storeRepository;
	
	public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
	 
	
    public List<StoreWithCountDTO> getMostUsedStoresExcludingMember(String memberId) {
    	
        List<Object[]> results = storeRepository.findMostUsedStoresExcludingMember(memberId);

        return results.stream()
            .map(this::convertToStoreWithCountDTO) //DTO로 변환
            .collect(Collectors.toList());
    }
	 
	 
	//상위 3개 카테고리 정보 DTO로 변환
	 public List<StoreCategoryDTO> findTopCategoriesByMemberId(String memberId) {
        List<Object[]> results = storeRepository.findTopCategoriesByMemberId(memberId);

        // 결과를 DTO로 변환
        return results.stream()
            .map(result -> new StoreCategoryDTO(
                (String) result[0],  // category_code
                (String) result[1],  // category_name
                null                  // 카운트는 필요 없으므로 null 설정
            ))
            .collect(Collectors.toList());
    }


    //특정 회원의 결제 내역 카테고리 정보를 뽑아온 쿼리 결과를 DTO로 변환
    public List<StoreCategoryDTO> getMostUsedCategories(String memberId) {
        List<Object[]> results = storeRepository.findMostUsedCategoriesByMemberId(memberId);
        List<StoreCategoryDTO> categories = new ArrayList<>();
        
        for (Object[] result : results) {
            String categoryCode = (String) result[0];
            String categoryName = (String) result[1];
            Long usageCount = ((Number) result[2]).longValue();
            
            StoreCategoryDTO dto = new StoreCategoryDTO(categoryCode, categoryName, usageCount);
            categories.add(dto);
        }
        
        return categories;
    }
	
	//카카오맵API로 호출한 json 데이터를 가맹점 엔티티에 insert
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
                    StoreEntity store = new StoreEntity(store_id, store_name, store_phone,store_addr, store_road_addr , store_url,store_x,store_y, category_code, category_name);
                    
                    // Store 엔티티를 데이터베이스에 저장
                    storeRepository.save(store);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DTO(StoreWithCountDTO) 변환 함수
    private StoreWithCountDTO convertToStoreWithCountDTO(Object[] result) {
        String storeId = (String) result[0];
        String storeName = (String) result[1];
        String storeAddr = (String) result[2];
        String storeRoadAddr = (String) result[3];
        String storePhone = (String) result[4];
        String stroeUrl = (String) result[5];
        String stroeX = (String) result[6];
        String stroeY = (String) result[7];
        String categoryCode = (String) result[8];
        String categoryName = (String) result[9];
        Long paymentCount = ((Number) result[10]).longValue(); // 변경된 필드명

        return new StoreWithCountDTO(storeId, storeName, storeAddr, storeRoadAddr, storePhone, 
                                     stroeUrl, stroeX, stroeY, categoryCode, categoryName, paymentCount);
    }
    // 엔티티를 DTO(StoreDTO)로 변환하는 함수
    private StoreDTO entityToDTO(StoreEntity storeEntity) {
        return new StoreDTO(
            storeEntity.getStoreId(),
            storeEntity.getStoreName(),
            storeEntity.getStoreAddr(),
            storeEntity.getStoreRoadAddr(),
            storeEntity.getStorePhone(),
            storeEntity.getStoreUrl(),
            storeEntity.getStoreX(),
            storeEntity.getStoreY(),
            storeEntity.getCategoryCode(),
            storeEntity.getCategoryName()
        );
    }
}
