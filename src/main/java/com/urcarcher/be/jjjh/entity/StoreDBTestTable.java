package com.urcarcher.be.jjjh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="store")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDBTestTable {
    @Id
    private String store_id;  // PK

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

