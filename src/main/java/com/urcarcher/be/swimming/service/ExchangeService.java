package com.urcarcher.be.swimming.service;

import java.util.List;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.kimyuri.CardDTO;
import com.urcarcher.be.kimyuri.CardEntity;
import com.urcarcher.be.kimyuri.CardTypeEntity;
import com.urcarcher.be.swimming.dto.ExchangeCardDTO;
import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;

public interface ExchangeService {
	// 카드 리스트 조회
	List<ExchangeCardDTO> getList(String memberId);
	
	// 바로 충전
	void exchangeInsert(ExchangeInfoDTO infoDto, String memberId);
	
	// DTO -> Entity
	default ExchangeInfoEntity dtoToEntity(ExchangeInfoDTO infoDto) {
		Member memberEntity = Member.builder()
				.memberId("bleakwinter")
				.build();
		
		CardEntity cardEntity = CardEntity.builder()
				.cardId(infoDto.getCardId())
				.build();
		
		ExchangeInfoEntity infoEntity = ExchangeInfoEntity.builder()
				.exId(infoDto.getExId())
				.exRate(infoDto.getExRate())
				.exCur(infoDto.getExCur())
				.exPay(infoDto.getExPay())
				.exDate(infoDto.getExDate())
				.card(cardEntity)
				.build();
		
		System.out.println("******************** infoEntity 확인 : " + infoEntity);
		return infoEntity;
	}
	
	// Entity -> DTO
	default ExchangeInfoDTO entityToDto(ExchangeInfoEntity infoEntity) {
		ExchangeInfoDTO infoDto = ExchangeInfoDTO.builder()
				.exId(infoEntity.getExId())
				.cardId(infoEntity.getCard().getCardId())
				.cardUsage(infoEntity.getCard().getCardType().getCardUsage())
				.exRate(infoEntity.getExRate())
				.exCur(infoEntity.getExCur())
				.exPay(infoEntity.getExPay())
				.exDate(infoEntity.getExDate())
				.build();
		
		System.out.println("******************** infoDTO 확인 : " + infoDto);
		return infoDto;
	}
	
	// 카드 리스트 조회 Entity -> DTO
	default ExchangeCardDTO cardEntityToDto(CardEntity card, CardTypeEntity type) {
		ExchangeCardDTO dto = ExchangeCardDTO.builder()
				.cardId(card.getCardId())
				.cardBalance(card.getCardBalance())
				.cardUsage(type.getCardUsage())
				.build();
		
		return dto;
	}
}