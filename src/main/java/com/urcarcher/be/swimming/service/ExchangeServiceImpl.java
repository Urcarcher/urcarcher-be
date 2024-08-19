package com.urcarcher.be.swimming.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.urcarcher.be.kimyuri.CardDTO;
import com.urcarcher.be.kimyuri.CardEntity;
import com.urcarcher.be.kimyuri.CardTypeEntity;
import com.urcarcher.be.swimming.dto.ExchangeCardDTO;
import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;
import com.urcarcher.be.swimming.repository.ExchangeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {
	final ExchangeRepository InfoRepo;
	
	// 카드 리스트 조회
	@Override
	public List<ExchangeCardDTO> getList(String memberId) {
		List<Object[]> entityList = InfoRepo.findByMemberId(memberId);
		
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
					CardEntity card = (CardEntity)arr[0];
					CardTypeEntity type = (CardTypeEntity)arr[1];
					return cardEntityToDto(card, type);
				})
				.collect(Collectors.toList());

        return dtoList;
	}
	
	// 바로 충전
	@Transactional
	@Override
	public void exchangeInsert(ExchangeInfoDTO infoDto, String memberId) {
		// 충전할 카드 가져오기
		CardEntity card = InfoRepo.findByCard(memberId, infoDto.getCardId());
		
		// 카드잔액 + 환전금액
		if (card != null) {
			Double plusCur = card.getCardBalance() + infoDto.getExCur().doubleValue();
			InfoRepo.plusCurrency(card.getCardId(), plusCur);
		}
		
		// 환전 내역에 추가
		ExchangeInfoEntity newInfoEtt = InfoRepo.save(dtoToEntity(infoDto));
	}
}