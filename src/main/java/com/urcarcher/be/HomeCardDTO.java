package com.urcarcher.be;

import com.urcarcher.be.kimyuri.CardTypeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class HomeCardDTO {
	private Long cardId;
    private Double cardBalance;
    private String cardAccount;
    private String cardName;
    private String cardUsage;//신용카드 or 선불카드
    private Double totalPayment; //이번달 총 카드 사용 금액
}
