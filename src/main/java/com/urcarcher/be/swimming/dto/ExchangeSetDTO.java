package com.urcarcher.be.swimming.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeSetDTO {
	private Long setId; // 예약번호 (PK)
	private Long cardId; // 카드 ID (FK)
	private Double setRate; // 예약환율
	private Long setCur; // 예약금액
	private Timestamp setDate; // 예약일시
}