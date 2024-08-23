package com.urcarcher.be.swimming;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.swimming.dto.ExchangeCardDTO;
import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.dto.ExchangeSetDTO;
import com.urcarcher.be.swimming.service.ExchangeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/exchange")
public class ExchangeRestController {
	final ExchangeService exService;

	// 카드 리스트 조회
	@GetMapping("/list")
	public List<ExchangeCardDTO> getList() {
		String memberId = "bleakwinter";
//		String memberId = "happy";


		return exService.getList(memberId);
	}

	// 바로 환전
	@PostMapping("/insert")
	public String exchangeInsert(@RequestBody ExchangeInfoDTO infoDto) {
		String memberId = "bleakwinter";
//		String memberId = "happy";

		exService.exchangeInsert(infoDto, memberId);

		Long currency = infoDto.getExCur();

        // KRW 형식으로 변환
        NumberFormat krwFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formatAmount = krwFormat.format(currency);

		return "KRW " + formatAmount;
	}
	
	// 예약 내역 조회
	@GetMapping("/rate/detail/{cardId}")
	public ExchangeSetDTO setDetail(@PathVariable("cardId") Long cardId) {
		String memberId = "bleakwinter";
		
		return exService.setDetail(cardId, memberId);
	}
	
	// 예약 환전
	@PostMapping("/rate/insert")
	public void setInsert(@RequestBody ExchangeSetDTO setDto) {
		String memberId = "bleakwinter";
//		System.out.println("******************** 예약일 확인 : " + setDto.getSetDate());
		exService.setInsert(setDto, memberId);
	}
	
	// 예약 내역 삭제
	@DeleteMapping("/rate/delete/{setId}")
	public void setDelete(@PathVariable("setId") Long setId) {
		exService.setDelete(setId);
	}
}