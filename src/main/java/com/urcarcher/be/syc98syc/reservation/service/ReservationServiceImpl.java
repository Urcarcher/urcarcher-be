package com.urcarcher.be.syc98syc.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.blkwntr.repository.MemberRepository;
import com.urcarcher.be.syc98syc.entity.ReservationEntity;
import com.urcarcher.be.syc98syc.repository.ReservationRepository;
import com.urcarcher.be.syc98syc.reservation.dto.ReservationDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

	private final ReservationRepository rRepo;
	private final MemberRepository mRepo;

	@Override
	public void create(ReservationDTO dto) {
		Member member = mRepo.findById(dto.getMemberId()).orElseThrow(() -> new RuntimeException("Member not found"));
		ReservationEntity entity = dtoToEntity(dto, member);
		rRepo.save(entity);
	}

}
