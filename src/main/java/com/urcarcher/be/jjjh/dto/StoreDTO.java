package com.urcarcher.be.jjjh.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
	
    private String store_id; 

    private String store_name;

    private String store_phone;

    private String store_addr;
    
    private String store_road_addr;
    
    private String stroe_url;
    
    private String stroe_x; //경도
    
    private String stroe_y; //위도
    
    private String category_code;  
    
    private String category_name;  
}
