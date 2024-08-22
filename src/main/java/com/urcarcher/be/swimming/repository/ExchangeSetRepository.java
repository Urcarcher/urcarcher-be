package com.urcarcher.be.swimming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.urcarcher.be.swimming.entity.ExchangeSetEntity;

public interface ExchangeSetRepository extends JpaRepository<ExchangeSetEntity, Long> {
	// 예약 내역 조회
	@Query("SELECT s FROM ExchangeSetEntity s"
			+ " JOIN CardEntity c on (s.card = c)"
			+ " WHERE c.cardId = ?1")
	ExchangeSetEntity findByCurSet(Long cardId);
}