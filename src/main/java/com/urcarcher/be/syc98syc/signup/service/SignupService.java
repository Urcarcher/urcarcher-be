package com.urcarcher.be.syc98syc.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.syc98syc.entity.MemberTest;
import com.urcarcher.be.syc98syc.repository.SignupRepository;
import com.urcarcher.be.syc98syc.signup.dto.MemberDTO;

public interface SignupService {
	
	String signupLocalMember(MemberDTO dto);
	
	//DTO -> Entity (DB에 반영하기위함)
		//insert, update시 사용
		default MemberTest dtoToEntity(MemberDTO dto) {
			MemberTest entity = MemberTest.builder()
			        .memberId(dto.getMemberId())
			        .email(dto.getEmail())
			        .gender(dto.getGender())
			        .informationConsent(dto.getInformationConsent())
			        .locationConsent(dto.getLocationConsent())
			        .matchingConsent(dto.getMatchingConsent())
			        .name(dto.getName())
			        .password(dto.getPassword())
			        .phoneNumber(dto.getPhoneNumber())
			        .dateOfBirth(dto.getDateOfBirth())
			        .nationality(dto.getNationality())
			        .build();
			return entity;
		}
}
