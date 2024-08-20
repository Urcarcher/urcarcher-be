package com.urcarcher.be.swimming.service;

import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;

public interface ExchangeService {
	// 소유한 카드 정보 조회
	// List<CardDTO> getList();
	
	// 바로 충전 입력
	void exchangeInsert(ExchangeInfoDTO infoDto);
	
	// DTO -> Entity
	default ExchangeInfoEntity dtoToEntity(ExchangeInfoDTO infoDto) {
		ExchangeInfoEntity infoEntity = ExchangeInfoEntity.builder()
				.exId(infoDto.getExId())
				.cardId(infoDto.getCardId())
				.exRate(infoDto.getExRate())
				.exCur(infoDto.getExCur())
				.exPay(infoDto.getExPay())
				.exDate(infoDto.getExDate())
				.build();
		
//		System.out.println("******************** infoEntity 확인 : " + infoEntity);
		return infoEntity;
	}
	
	// Entity -> DTO
	default ExchangeInfoDTO entityToDto(ExchangeInfoEntity infoEntity) {
		ExchangeInfoDTO infoDto = ExchangeInfoDTO.builder()
				.exId(infoEntity.getExId())
				.cardId(infoEntity.getCardId())
				.exRate(infoEntity.getExRate())
				.exCur(infoEntity.getExCur())
				.exPay(infoEntity.getExPay())
				.exDate(infoEntity.getExDate())
				.build();
		
		return infoDto;
	}
}