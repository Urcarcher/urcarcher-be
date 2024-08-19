package com.urcarcher.be.swimming.service;

import org.springframework.stereotype.Service;

import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;
import com.urcarcher.be.swimming.repository.ExchangeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {
	final ExchangeRepository InfoRepo;
	
	// 소유한 카드 정보 조회
	/*
	@Override
    public List<CardDTO> getList() {
        List<CardEntity> entityList = (List<CardEntity>) InfoRepo.findAll();

        List<CardDTO> dtoList = entityList.stream().map(entity -> entityToDto(entity))
                .collect(Collectors.toList());

        return dtoList;
    }
    */
	
	// 바로 충전 입력
	@Override
	public void exchangeInsert(ExchangeInfoDTO infoDto) {
		ExchangeInfoEntity newInfoEtt = InfoRepo.save(dtoToEntity(infoDto));
		
		InfoRepo.save(newInfoEtt);
	}
}