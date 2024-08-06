package com.urcarcher.be.kimyuri;

import java.util.List;

public interface CardService {
	
	CardEntity save(CardEntity card);
	List<CardEntity> findAll();
	CardEntity findById(Long id);
	void deleteById(Long id);
	
}
