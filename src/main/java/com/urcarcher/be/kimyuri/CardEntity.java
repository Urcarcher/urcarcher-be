package com.urcarcher.be.kimyuri;

import java.time.LocalDate;

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
@Table(name = "card")
public class CardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cardId;

	@Column(length = 100, nullable = false)
	String cardNumber;
	@Column(length = 100, nullable = false)
	String cvvCode;
	@Column
	Double cardBalance;
	@Column(length = 100, nullable = false)
	String cardStatus;
	@Column(nullable = false)
	LocalDate issueDate;
	@Column(nullable = false)
	LocalDate expirationDate;

//	@ManyToOne
//	@JoinColumn(name = "member_id", nullable = false)
//	MemberEntity member;

//	@ManyToOne
//	@JoinColumn(name = "card_type_id", nullable = false)
//	CardTypeEntity cardType;

}
