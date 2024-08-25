package com.urcarcher.be.kimyuri;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	final PaymentRepository paymentRepo;

	@Override
	public void insert(PaymentDTO dto) {
		PaymentEntity entity = dtoToEntity(dto);
		paymentRepo.save(entity);
	}

	@Override
	public List<PaymentDTO> readAll() {
		List<PaymentEntity> entityList = (List<PaymentEntity>) paymentRepo.findAll();

		List<PaymentDTO> dtoList = entityList.stream().map(entity -> entityToDTO(entity)).collect(Collectors.toList());
		return dtoList;

//		  기존 findAll() 대신 findAllPaymentsWithStoreName() 사용
//        return paymentRepo.findAllPaymentsWithStoreName();
	}

	@Override
	public PaymentDTO readById(Long paymentId) {
		PaymentEntity entity = paymentRepo.findById(paymentId).orElse(null);
		return entity != null ? entityToDTO(entity) : null;
	}

	@Override
	public PaymentDTO readBycardId(Long cardId) {
		// 가장 최근 결제 내역을 Optional로 받아오기
		Optional<PaymentEntity> entityOptional = paymentRepo.findTopByCardCardIdOrderByPaymentDateDesc(cardId);

		// Optional이 비어있지 않으면, PaymentEntity를 PaymentDTO로 변환
		return entityOptional.map(entity -> entityToDTO(entity)).orElse(null);
	}

	@Override
	public List<PaymentDTO> findPaymentsByMemberId(String memberId) {
		List<PaymentDTO> payments = paymentRepo.findAllPaymentsByMemberId(memberId);
		return payments;
	}

	@Override
	public void delete(Long paymentId) {
		paymentRepo.deleteById(paymentId);
	}

}
