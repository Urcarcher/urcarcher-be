package com.urcarcher.be.kimyuri;

import java.util.List;

public interface CardIssueHistoryService {
	CardIssueHistoryEntity save(CardIssueHistoryEntity cardIssueHistory);
	List<CardIssueHistoryEntity> findAll();
	CardIssueHistoryEntity findById(Long id);
	void deleteById(Long id);
}
