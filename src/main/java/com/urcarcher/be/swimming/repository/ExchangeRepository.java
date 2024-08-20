package com.urcarcher.be.swimming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.urcarcher.be.kimyuri.CardEntity;
import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;

import jakarta.transaction.Transactional;

public interface ExchangeRepository extends JpaRepository<ExchangeInfoEntity, Long> {
	// 카드 리스트 조회
	@Query("SELECT c, ct FROM CardEntity c"
			+ " JOIN Member m on (c.member = m)"
			+ " JOIN CardTypeEntity ct on (c.cardType = ct)"
			+ " WHERE m.memberId = ?1")
	List<Object[]> findByMemberId(String memberId);
	
	// 충전할 카드 가져오기
	@Query("SELECT c, ct FROM CardEntity c"
			+ " JOIN Member m on (c.member = m)"
			+ " JOIN CardTypeEntity ct on (c.cardType = ct)"
			+ " WHERE m.memberId = ?1 AND c.cardId = ?2")
	CardEntity findByCard(String memberId, Long cardId);
	
	// 바로 충전 시 카드잔액 + 환전금액
	@Transactional
	@Modifying
	@Query("UPDATE CardEntity c SET c.cardBalance = ?2"
			+ " WHERE c.cardId = ?1")
	void plusCurrency(Long cardId, Double currency);
}