package com.urcarcher.be.blkwntr.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MEMBER")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
	
	@Id
	String memberId;
	String password;
	
	String name;
	String email;
	String dateOfBirth;
	String gender;
	String nationality;
	String passportNumber;
	String phoneNumber;
	
	String locationConsent;
	String informationConsent;
	String matchingConsent;
	
	@CreationTimestamp
	Timestamp registrationDate;
}
