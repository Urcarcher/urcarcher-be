package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CardIssueHistoryServiceImpl implements CardIssueHistoryService{
	
	final CardIssueHistoryRepository cardIssueRepo;
	
	@Override
	public CardIssueHistoryEntity save(CardIssueHistoryEntity cardIssueHistory) {
		return cardIssueRepo.save(cardIssueHistory);
	}
	
	@Override
	public List<CardIssueHistoryEntity> findAll(){
		return cardIssueRepo.findAll();
	}
	
	@Override
	public CardIssueHistoryEntity findById(Long id) {
		return cardIssueRepo.findById(id).orElse(null);
	}
	
	@Override
	public void deleteById(Long id) {
		cardIssueRepo.deleteById(id);
	}
	
}
