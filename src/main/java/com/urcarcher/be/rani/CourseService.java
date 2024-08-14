package com.urcarcher.be.rani;

import java.util.List;

import com.urcarcher.be.rani.VO.CourseCategoryEntity;
import com.urcarcher.be.rani.VO.CourseDTO;
import com.urcarcher.be.rani.VO.PlaceDTO;
import com.urcarcher.be.rani.VO.TravelCourseEntity;

public interface CourseService {

	
	List<CourseDTO> getCourseList();
	List<PlaceDTO> getPlaceList(String courseId);
	
	//DTO -> Entity 
	
	
	//Entity -> DTO 
	default CourseDTO entityToDTO(CourseCategoryEntity entity) {
		CourseDTO dto = CourseDTO.builder()
				.courseId(entity.getCourseId())
				.courseName(entity.getCourseName())
				.region(entity.getRegion())
				.build();
		return dto;
	}
	
	default PlaceDTO entityToDTO (TravelCourseEntity entity) {
		PlaceDTO dto = PlaceDTO.builder()
				.placeId(entity.getId().getPlaceId())
				.placeName(entity.getPlaceName())
				.address(entity.getAddress())
				.latitude(entity.getLatitude())
				.longitude(entity.getLongitude())
				.content(entity.getContent())
				.detailContent(entity.getDetailContent())
				.placeImg(entity.getPlaceImg())
				.build();
		return dto;
	}
}
