package com.urcarcher.be.swimming.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.urcarcher.be.kimyuri.CardEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "EXCHANGE_SET")
public class ExchangeSetEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long setId; // 예약번호
	
	// @Column(nullable = false)
	// private Long cardId; // 카드 ID (관계설정 후 삭제해야 함)
	
	@Column(nullable = false)
	private Double setRate; // 예약환율
	
	@Column(nullable = false)
	private Long setCur; // 예약금액
	
	@CreationTimestamp
	private Timestamp setDate; // 예약일시
	
	// ExchangeInfoEntity 클래스에 있는 필드명
	@OneToMany(mappedBy = "exchangeSet", 
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	List<ExchangeInfoEntity> infoList;
	
	@JoinColumn(name = "card_id")
	@OneToOne
	CardEntity card;
}