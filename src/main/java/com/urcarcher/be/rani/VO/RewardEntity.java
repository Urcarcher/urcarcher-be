package com.urcarcher.be.rani.VO;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table (name="reward")
public class RewardEntity {

	@Id
	@Column (name= "reward_id")
	private String rewardId;
	
	@Column (name= "member_id")
	private String memberId;
	
	@Column (name= "point_amount")
	private int pointAmount;
	
	@CreationTimestamp
	@Column (name= "payment_date")
	private Date paymentDate;
}
