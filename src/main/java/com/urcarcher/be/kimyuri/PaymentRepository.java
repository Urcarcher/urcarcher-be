package com.urcarcher.be.kimyuri;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	@Query("SELECT new com.urcarcher.be.kimyuri.PaymentDTO(p.paymentId, p.paymentPrice, p.paymentDate,  p.card.cardId, s.storeId, s.storeName, s.categoryCode) " +
	           "FROM PaymentEntity p JOIN p.store s")
	    List<PaymentDTO> findAllPaymentsWithStoreName();
	
    Optional<PaymentEntity> findTopByCardCardIdOrderByPaymentDateDesc(Long cardId);

}