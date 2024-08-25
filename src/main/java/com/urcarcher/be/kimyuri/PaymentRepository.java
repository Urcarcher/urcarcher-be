package com.urcarcher.be.kimyuri;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	@Query("SELECT new com.urcarcher.be.kimyuri.PaymentDTO(p.paymentId, p.paymentPrice, p.paymentDate,  p.card.cardId, s.storeId, s.storeName, s.categoryCode) " +
	           "FROM PaymentEntity p JOIN p.store s")
	    List<PaymentDTO> findAllPaymentsWithStoreName();
	
    Optional<PaymentEntity> findTopByCardCardIdOrderByPaymentDateDesc(Long cardId);

    List<PaymentEntity> findByCard_CardIdAndPaymentDateBetweenAndIsInstantPaymentFalse(Long cardId, LocalDateTime startDate, LocalDateTime endDate);
    
    @Transactional
    @Modifying
    @Query("UPDATE PaymentEntity p SET p.isInstantPayment = true WHERE p.card.cardId = :cardId AND p.paymentDate BETWEEN :startDate AND :endDate")
    int updatePaymentStatusToTrue(@Param("cardId") Long cardId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}