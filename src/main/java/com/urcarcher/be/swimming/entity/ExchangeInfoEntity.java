package com.urcarcher.be.swimming.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.urcarcher.be.kimyuri.CardEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "EXCHANGE_INFO")
public class ExchangeInfoEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long exId; // 환전번호
	
//	@Column(nullable = false)
//	private Long cardId; // 카드 ID (관계설정 후 삭제해야 함)
	
	@Column(nullable = false)
	private Double exRate; // 적용환율
	
	@Column(nullable = false)
	private Long exCur; // 환전금액
	
	@Column(nullable = false)
	private Double exPay; // 결제금액
	
	@CreationTimestamp
	private Timestamp exDate; // 환전일시
	
	@JoinColumn(name = "SET_ID", nullable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	ExchangeSetEntity exchangeSet;
	
	@JoinColumn(name = "card_id")
	@ManyToOne
	CardEntity card;
}