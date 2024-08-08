package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentRestController {
	final PaymentService paymentService;
	
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
}
