package com.urcarcher.be.kimyuri;
import java.util.List;

import com.urcarcher.be.jjjh.entity.StoreEntity;

public interface PaymentService {
	
	void insert(PaymentDTO dto);
	
	List<PaymentDTO> readAll();
	
	PaymentDTO readById(Long paymentId);
	
	void delete(Long paymentId);
	
	PaymentDTO readBycardId(Long cardId);
	
	// Entity -> DTO
	default PaymentDTO entityToDTO(PaymentEntity entity) {
		PaymentDTO dto = PaymentDTO.builder()
				.paymentId(entity.getPaymentId())
				.paymentPrice(entity.getPaymentPrice())
				.paymentDate(entity.getPaymentDate())
                .cardId(entity.getCard().getCardId())
                .storeId(entity.getStore().getStoreId())
				.storeName(entity.getStore().getStoreName())
				.categoryCode(entity.getStore().getCategoryCode())
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
				        .storeId(dto.getStoreId())
				        .storeName(dto.getStoreName())
				        .categoryCode(dto.getCategoryCode())
				        .build())
	           
				.build();
		return entity;
	}
	
	
	
}