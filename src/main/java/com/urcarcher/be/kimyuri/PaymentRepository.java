package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	@Query("SELECT new com.urcarcher.be.kimyuri.PaymentDTO(p.paymentId, p.paymentPrice, p.paymentDate,  p.card.cardId, s.storeId, s.storeName, s.categoryCode) " +
	           "FROM PaymentEntity p JOIN p.store s")
	    List<PaymentDTO> findAllPaymentsWithStoreName();
}
