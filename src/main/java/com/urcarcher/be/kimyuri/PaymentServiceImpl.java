package com.urcarcher.be.kimyuri;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PaymentServiceImpl implements PaymentService{
	
	final PaymentRepository paymentRepo;
	
	@Override
	public void insert(PaymentDTO dto) {
		PaymentEntity entity = dtoToEntity(dto);
		paymentRepo.save(entity);
	}
	
	@Override
	public List<PaymentDTO> readAll() {
		List<PaymentEntity> entityList = (List<PaymentEntity>) paymentRepo.findAll();
		
		List<PaymentDTO> dtoList = entityList.stream().map(entity -> entityToDTO(entity))
				.collect(Collectors.toList());
		return dtoList;
	}
	
	@Override
	public PaymentDTO readById(Long paymentId) {
		PaymentEntity entity = paymentRepo.findById(paymentId).orElse(null);
	    return entity != null ? entityToDTO(entity) : null;
	}
	
	@Override
	public void delete(Long paymentId) {
		paymentRepo.deleteById(paymentId);
	}
	
}


