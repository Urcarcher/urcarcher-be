package com.urcarcher.be.kimyuri;

import java.util.List;


public interface PaymentService {
	
	void insert(PaymentDTO dto);
	
	List<PaymentDTO> readAll();
	
	PaymentDTO readById(Long paymentId);
	
	void delete(Long paymentId);
	
	// Entity -> DTO
	default PaymentDTO entityToDTO(PaymentEntity entity) {
//		PaymentDTO dto = PaymentDTO.builder()
//				.paymentId(entity.getPaymentId())
//				.paymentPrice(entity.getPaymentPrice())
//				.paymentDate(entity.getPaymentDate())
//                .cardId(entity.getCard().getCardId())
//                .store_id(entity.getStore().getStore_id())
//				.store_name(entity.getStore().getStore_name())
//				.category_code(entity.getStore().getCategory_code())
//				.build();
		return null;
	}
	
	
	// DTO -> Entity
	default PaymentEntity dtoToEntity(PaymentDTO dto) {
		
//		PaymentEntity entity = PaymentEntity.builder()
//				.paymentId(dto.getPaymentId())
//				.paymentPrice(dto.getPaymentPrice())
//				.paymentDate(dto.getPaymentDate())
//				.card(CardEntity.builder().cardId(dto.getCardId()).build())
//				.store(StoreDBTestTable.builder()
//				        .store_id(dto.getStore_id())
//				        .store_name(dto.getStore_name())
//				        .category_code(dto.getCategory_code())
//				        .build())
//	            
//				.build();
		return null;
	}
	
	
	
}
