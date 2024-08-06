package com.urcarcher.be.rani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.rani.VO.TravelCourseEntity;

public interface PlaceRepository extends JpaRepository<TravelCourseEntity, String>{
	List<TravelCourseEntity> findByCourseId(String coursId);
}
