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
  
	// 카드 정보 가져오기
	@Query("SELECT c, ct FROM CardEntity c"
			+ " JOIN Member m on (c.member = m)"
			+ " JOIN CardTypeEntity ct on (c.cardType = ct)"
			+ " WHERE m.memberId = ?1 AND c.cardId = ?2")
	CardEntity findByCard(String memberId, Long cardId);

	// 환전 시 카드잔액 + 환전금액 update
	@Transactional
	@Modifying
	@Query("UPDATE CardEntity c SET c.cardBalance = ?2"
			+ " WHERE c.cardId = ?1")
	void plusCurrency(Long cardId, Double currency);
	
	// 카드 별 환전 내역 전체 조회
	@Query("SELECT e, c, s FROM ExchangeInfoEntity e"
			+ " JOIN CardEntity c on (e.card = c)"
			+ " LEFT JOIN ExchangeSetEntity s on (e.exchangeSet = s)"
			+ " WHERE c.cardId = ?1")
	List<ExchangeInfoEntity> findByExchangeInfo(Long cardID);
	
	// 환전 내역 상세 조회
	@Query("SELECT e, c, s FROM ExchangeInfoEntity e"
			+ " JOIN CardEntity c on (e.card = c)"
			+ " LEFT JOIN ExchangeSetEntity s on (e.exchangeSet = s)"
			+ " WHERE e.exId = ?1")
	ExchangeInfoEntity findByInfoDetail(Long exId);
}