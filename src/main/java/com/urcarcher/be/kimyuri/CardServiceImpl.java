package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CardServiceImpl implements CardService{

	final CardRepository cardRepo;
	
	@Override
	public CardEntity save(CardEntity card) {
		return cardRepo.save(card);
	}
	
	@Override
	public List<CardEntity> findAll(){
		return cardRepo.findAll();
	}
	
	@Override
	public CardEntity findById(Long id) {
		return cardRepo.findById(id).orElse(null);
	}
	
	@Override
	public void deleteById(Long id) {
		cardRepo.deleteById(id);
	}
}
