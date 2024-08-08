package com.urcarcher.be.kimyuri;

import java.util.List;

public interface CardService {

	// 입력
	void create(CardDTO dto);
	
	// 조회
	List<CardDTO> readAll();
	
	// 상세보기
	CardDTO readById(Long cardId);
	
	// 수정
	void update(CardDTO dto);
	
	// 삭제
	void delete(Long cardId);
	
	// Entity -> DTO
	default CardDTO entityToDTO(CardEntity entity) {
		CardDTO dto = CardDTO.builder()
				.cardId(entity.getCardId())
				.cardNumber(entity.getCardNumber())
				.cvvCode(entity.getCvvCode())
				.cardBalance(entity.getCardBalance())
				.cardStatus(entity.getCardStatus())
				.issueDate(entity.getIssueDate())
				.expirationDate(entity.getExpirationDate())
				.build();
		return dto;
				
	}
	
	
	// DTO -> Entity
	default CardEntity dtoToEntity(CardDTO dto) {
		
		CardEntity entity = CardEntity.builder()
				.cardId(dto.getCardId())
				.cardNumber(dto.getCardNumber())
				.cvvCode(dto.getCvvCode())
				.cardBalance(dto.getCardBalance())
				.cardStatus(dto.getCardStatus())
				.issueDate(dto.getIssueDate())
				.expirationDate(dto.getExpirationDate())
				.build();
		return entity;
	}
	
	
	
}
