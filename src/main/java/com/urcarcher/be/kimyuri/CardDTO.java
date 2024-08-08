package com.urcarcher.be.kimyuri;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class CardDTO {
	Long cardId;
	String cardNumber;
	String cvvCode; 
	Double cardBalance;
	String cardStatus;
	LocalDate issueDate;
	LocalDate expirationDate;
}
