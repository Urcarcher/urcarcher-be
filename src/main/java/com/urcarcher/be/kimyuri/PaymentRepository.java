package com.urcarcher.be.kimyuri;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    // 상점 이름과 함께 모든 결제 내역 가져오기
    @Query("SELECT new com.urcarcher.be.kimyuri.PaymentDTO(p.paymentId, p.paymentPrice, p.paymentDate,  p.card.cardId, s.storeId, s.storeName, s.categoryCode) " +
           "FROM PaymentEntity p JOIN p.store s")
    List<PaymentDTO> findAllPaymentsWithStoreName();
    
    // 특정 카드 ID의 가장 최근 결제 내역 가져오기
    Optional<PaymentEntity> findTopByCardCardIdOrderByPaymentDateDesc(Long cardId);

    // 특정 memberId로 결제 내역 가져오기
    @Query("SELECT new com.urcarcher.be.kimyuri.PaymentDTO(p.paymentId, p.paymentPrice, p.paymentDate, p.card.cardId, s.storeId, s.storeName, s.categoryCode) " +
           "FROM PaymentEntity p JOIN p.store s " +
           "WHERE p.card.member.memberId = :memberId")
    List<PaymentDTO> findAllPaymentsByMemberId(@Param("memberId") String memberId);
}
