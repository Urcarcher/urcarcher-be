package com.urcarcher.be.kimyuri;

import java.util.List;

import com.urcarcher.be.jjjh.entity.StoreEntity;

public interface PaymentService {
	
	void insert(PaymentDTO dto);
	
	List<PaymentDTO> readAll();
	
	PaymentDTO readById(Long paymentId);
	
	void delete(Long paymentId);
	
	// Entity -> DTO
	default PaymentDTO entityToDTO(PaymentEntity entity) {
		PaymentDTO dto = PaymentDTO.builder()
				.paymentId(entity.getPaymentId())
				.paymentPrice(entity.getPaymentPrice())
				.paymentDate(entity.getPaymentDate())
                .cardId(entity.getCard().getCardId())
                .store_id(entity.getStore().getStoreId())
				.store_name(entity.getStore().getStoreName())
				.category_code(entity.getStore().getCategoryCode())
				.build();
		return dto;
	}
	
	
	// DTO -> Entity
	default PaymentEntity dtoToEntity(PaymentDTO dto) {
		
		PaymentEntity entity = PaymentEntity.builder()
				.paymentId(dto.getPaymentId())
				.paymentPrice(dto.getPaymentPrice())
				.paymentDate(dto.getPaymentDate())
				.card(CardEntity.builder().cardId(dto.getCardId()).build())
				.store(StoreEntity.builder()
				        .storeId(dto.getStore_id())
				        .storeName(dto.getStore_name())
				        .categoryCode(dto.getCategory_code())
				        .build())
	            
				.build();
		return entity;
	}
	
	
	
}
