package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PaymentServiceImpl implements PaymentService{
	final PaymentRepository paymentRepo;
	
	@Override
	public PaymentEntity save(PaymentEntity payment) {
		return paymentRepo.save(payment);
	}
	
	@Override
	public List<PaymentEntity> findAll(){
		return paymentRepo.findAll();
	}
	
	@Override
	public PaymentEntity findById(Long id) {
		return paymentRepo.findById(id).orElse(null);
	}
	
	@Override
	public void deleteById(Long id) {
		paymentRepo.deleteById(id);
	}
}
