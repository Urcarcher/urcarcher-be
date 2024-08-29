package com.urcarcher.be.syc98syc.reservation.service;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.syc98syc.entity.ReservationEntity;
import com.urcarcher.be.syc98syc.reservation.dto.ReservationDTO;

public interface ReservationService {
	
	void create(ReservationDTO dto);
	
	// DTO -> Entity
		default ReservationEntity dtoToEntity(ReservationDTO dto, Member member) {
			
			ReservationEntity entity = ReservationEntity.builder()
					.reservationId(dto.getReservationId())
					.peopleNum(dto.getPeopleNum())
					.reservationDate(dto.getReservationDate())
					.state(dto.getState())
					.location(dto.getLocation())
					.classification(dto.getClassification())
					.price(dto.getPrice())
					.name(dto.getName())
					.seat(dto.getSeat())
					.member(member)
					.build();
			return entity;
		}

}
