package com.urcarcher.be.swimming.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.urcarcher.be.kimyuri.CardEntity;
import com.urcarcher.be.kimyuri.CardTypeEntity;
import com.urcarcher.be.swimming.dto.ExchangeCardDTO;
import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;

import com.urcarcher.be.swimming.dto.ExchangeSetDTO;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;
import com.urcarcher.be.swimming.entity.ExchangeSetEntity;
import com.urcarcher.be.swimming.repository.ExchangeRepository;
import com.urcarcher.be.swimming.repository.ExchangeSetRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {

	final ExchangeRepository exRepo;
	final ExchangeSetRepository setRepo;
	
	// 카드 리스트 조회
	@Override
	public List<ExchangeCardDTO> getList(String memberId) {
		List<Object[]> entityList = exRepo.findByMemberId(memberId);
		
		/*
		List<CardDTO> dtoList = entityList.stream().map(entity -> cardEntityToDto(entity)).collect(Collectors.toList());
		
		entityList.forEach(arr -> {
			CardEntity card = (CardEntity)arr[0];
			CardTypeEntity cardType = (CardTypeEntity)arr[1];
		
			System.out.println(Arrays.toString(arr));
		});
		*/
		
		List<ExchangeCardDTO> dtoList = entityList.stream()
				.map(arr -> {
					// 오브젝트 타입의 배열이 들어오기 때문에 지정
					CardEntity card = (CardEntity)arr[0];
					CardTypeEntity type = (CardTypeEntity)arr[1];
				
					return cardEntityToDto(card, type);
				})
				.collect(Collectors.toList());

        return dtoList;
	}
	
	// 바로 환전
	@Transactional
	@Override
	public void exchangeInsert(ExchangeInfoDTO infoDto, String memberId) {
		// 환전할 카드 가져오기
		CardEntity card = exRepo.findByCard(memberId, infoDto.getCardId());
		
		// 카드잔액 + 환전금액 update
		if (card != null) {
			Double plusCur = card.getCardBalance() + infoDto.getExCur().doubleValue();
			exRepo.plusCurrency(card.getCardId(), plusCur);
		}
		
		// 환전 내역에 추가
		exRepo.save(infoDtoToEntity(infoDto));
	}
	
	// 예약 내역 조회
	@Override
	public ExchangeSetDTO setDetail(Long cardId, String memberId) {
		// 예약할 카드 가져오기
		CardEntity card = exRepo.findByCard(memberId, cardId);
		
		ExchangeSetEntity entity = setRepo.findByCurSet(card.getCardId());
		// System.out.println("******************** entity 확인" + entity);
		
		if (entity == null) return null;
		
		return setEntityToDto(entity);
	}

	// 예약 환전
	@Override
	public void setInsert(ExchangeSetDTO setDto, String memberId) {
		// 예약 환전 시 설정한 예약일에 자동으로 환전 내역 insert, 카드 잔액 update
		// 동시성 처리를 위해 DB 이벤트 스케줄러를 이용하여 트리거 생성함
		setRepo.save(setDtoToEntity(setDto));
	}

	// 예약 내역 삭제
	@Override
	public void setDelete(Long setId) {
		setRepo.deleteById(setId);
	}

	// 환전 내역 전체 조회
	@Override
	public List<ExchangeInfoDTO> infoList(Long cardId, String memberId) {
		// 조회할 카드 가져오기
		CardEntity card = exRepo.findByCard(memberId, cardId);
		
		List<ExchangeInfoDTO> infoList = exRepo.findByExchangeInfo(card.getCardId())
				.stream().map(entity -> infoEntityToDto(entity))
				.collect(Collectors.toList());
		
		if (infoList == null) return null;
		
		return infoList;
	}

	// 환전 내역 상세 조회
	@Override
	public ExchangeInfoDTO infoDetail(Long exId) {
		ExchangeInfoEntity entity = exRepo.findByInfoDetail(exId);
		
		if (entity == null) return null;
		
		return infoEntityToDto(entity);
	}
}