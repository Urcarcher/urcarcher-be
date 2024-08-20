package com.urcarcher.be.swimming;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.kimyuri.CardDTO;
import com.urcarcher.be.swimming.dto.ExchangeCardDTO;
import com.urcarcher.be.swimming.dto.ExchangeInfoDTO;
import com.urcarcher.be.swimming.service.ExchangeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/exchange")
public class ExchangeRestController {
	final ExchangeService infoService;
	
	// 카드 리스트 조회
	@GetMapping("/list")
	public List<ExchangeCardDTO> getList() {
		String memberId = "bleakwinter";
		
		return infoService.getList(memberId);
	}
	
	// 바로 충전
	@PostMapping("/insert")
	String exchangeInsert(@RequestBody ExchangeInfoDTO infoDto) {
		String memberId = "bleakwinter";
		infoService.exchangeInsert(infoDto, memberId);
		
		Long currency = infoDto.getExCur();
        
        // KRW 형식으로 변환
        NumberFormat krwFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formatAmount = krwFormat.format(currency);
		
		return "KRW " + formatAmount;
	}
}