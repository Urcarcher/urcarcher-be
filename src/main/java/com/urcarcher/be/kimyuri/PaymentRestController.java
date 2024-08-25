package com.urcarcher.be.kimyuri;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentRestController {
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/list")
	List<PaymentDTO> list() {
		return paymentService.readAll();
	}
	
	@GetMapping("/get/{paymentId}")
	PaymentDTO read(@PathVariable("paymentId") Long paymentId) {
		return paymentService.readById(paymentId);
	}
	
	@PostMapping("/insert")
	String insert(@RequestBody PaymentDTO dto) {
		paymentService.insert(dto);
		return "입력작업";
	}
	
	@DeleteMapping("/delete/{paymentId}")
	String delete(@PathVariable("paymentId") Long paymentId) {
		paymentService.delete(paymentId);
		return "삭제작업";
	}
	
	// 카드관리 - 즉시결제
	@PostMapping("/immediatepayment")
	Boolean immediatePayment(@RequestBody Map<String, String> requestBody) {
		return paymentService.immediatePayment(Long.parseLong(requestBody.get("cardId")), requestBody.get("paymentDate"));
	}
	
	// 카드관리 - 결제내역
	@PostMapping("/detailpayment")
	Double detailPayment(@RequestBody Map<String, String> requestBody) {
		return paymentService.detailPayment(Long.parseLong(requestBody.get("cardId")), requestBody.get("paymentDate"));
	}
	
	// 카드 관리 - 최근 결제 내역 가져오기
	@PostMapping("/recentpayment")
	PaymentDTO readByCardId(@RequestBody Map<String, String> requestBody) {
		return paymentService.readBycardId(Long.parseLong(requestBody.get("cardId")));
	}
	
	// 예약금 결제
	@PostMapping("/depositpayment")
	void depositPayment(@RequestBody PaymentDTO dto) {
		paymentService.insert(dto);
	}
}
