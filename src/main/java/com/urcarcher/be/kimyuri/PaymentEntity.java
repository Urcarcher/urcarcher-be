package com.urcarcher.be.kimyuri;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class PaymentEntity {
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	private Double pay;
	private Date paymentDate;
	
	@ManyToOne
	@JoinColumn(name="cardId", nullable=false)
	private CardEntity card;
	
}
