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
	
    Long cardId;
    
    String store_id;
    String store_name;
    
    String category_code;
}
