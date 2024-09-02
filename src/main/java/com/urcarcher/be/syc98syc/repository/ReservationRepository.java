package com.urcarcher.be.syc98syc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urcarcher.be.syc98syc.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer>{
	// 특정 멤버의 모든 예약 정보를 조회
   // List<ReservationEntity> findAllByMemberId(String memberId);
	
//    @Query("SELECT r FROM ReservationEntity r WHERE r.member.memberId = :memberId")
//    List<ReservationEntity> findByMemberId(@Param("memberId") String memberId);
	
	@Query("SELECT r FROM ReservationEntity r WHERE r.member.memberId = :memberId ORDER BY r.state DESC, r.reservationDate ASC")
	List<ReservationEntity> findList1ByMemberId(@Param("memberId") String memberId);
}
