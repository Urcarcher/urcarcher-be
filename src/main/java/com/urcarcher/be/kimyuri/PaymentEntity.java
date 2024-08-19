package com.urcarcher.be.kimyuri;

import java.time.LocalDateTime;

import com.urcarcher.be.jjjh.entity.StoreDBTestTable;

import jakarta.persistence.Column;
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
	Long paymentId;

	@Column(nullable = false)
	Double paymentPrice;
	@Column(nullable = false)
	LocalDateTime paymentDate;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	StoreDBTestTable store;

	@ManyToOne
	@JoinColumn(name = "card_id", nullable = false)
	CardEntity card;

}
