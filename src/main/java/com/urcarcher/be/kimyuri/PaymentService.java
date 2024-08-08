package com.urcarcher.be.kimyuri;

import java.util.List;

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
				.build();
		return dto;
	}
	
	
	// DTO -> Entity
	default PaymentEntity dtoToEntity(PaymentDTO dto) {
		
		PaymentEntity entity = PaymentEntity.builder()
				.paymentId(dto.getPaymentId())
				.paymentPrice(dto.getPaymentPrice())
				.paymentDate(dto.getPaymentDate())
				.build();
		return entity;
	}
	
	
	
}
