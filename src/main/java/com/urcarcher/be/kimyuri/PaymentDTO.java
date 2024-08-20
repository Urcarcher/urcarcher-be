package com.urcarcher.be.kimyuri;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class PaymentDTO {
	Long paymentId;
	Double paymentPrice;
	LocalDateTime paymentDate;
	
	Long storeId;
    Long cardId;
    String storeName;
    
    String categoryCode;
}
