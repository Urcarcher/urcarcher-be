package com.urcarcher.be.kimyuri;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class SMSController {

	private DefaultMessageService messageService;
	private Map<String, String> verificationCodes = new HashMap<>(); // 전화번호별 인증번호 저장

	@Value("${coolsms.api.key}")
	private String apiKey;

	@Value("${coolsms.api.secret}")
	private String apiSecret;

	@Value("${coolsms.api.number}")
	private String fromNumber;

	@PostConstruct
	public void init() {
		this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
	}

	/**
	 * 단일 메시지 발송 예제
	 */
	@PostMapping("/send-one")
	public SingleMessageSentResponse sendOne(@RequestBody SMSRequest smsRequest) {
		String phoneNumber = smsRequest.getPhoneNumber();
		String verificationCode = generateVerificationCode();
		verificationCodes.put(phoneNumber, verificationCode); // 전화번호와 인증번호 매핑

		Message message = new Message();
		message.setFrom(fromNumber);
		message.setTo(phoneNumber);
		message.setText("인증번호는 " + verificationCode + "입니다.");

		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
		System.out.println(response);

		return response;
	}

	/**
	 * 인증번호 확인 예제
	 */
	@PostMapping("/verify-code")
	public boolean verifyCode(@RequestBody VerificationRequest verificationRequest) {
		String sentCode = verificationCodes.get(verificationRequest.getPhoneNumber());
		return verificationRequest.getVerificationCode().equals(sentCode);
	}

	private String generateVerificationCode() {
		Random random = new Random();
		int code = 100000 + random.nextInt(900000); // 100000 ~ 999999 사이의 랜덤 6자리 숫자 생성
		return String.valueOf(code);
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class SMSRequest {
	private String phoneNumber;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class VerificationRequest {
	private String phoneNumber;
	private String verificationCode;
}
