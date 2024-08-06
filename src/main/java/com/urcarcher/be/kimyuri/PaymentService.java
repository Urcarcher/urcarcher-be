package com.urcarcher.be.kimyuri;

import java.util.List;

public interface PaymentService {
	PaymentEntity save(PaymentEntity payment);
	List<PaymentEntity> findAll();
	PaymentEntity findById(Long id);
	void deleteById(Long id);
}
