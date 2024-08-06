package com.urcarcher.be.rani;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urcarcher.be.rani.VO.CourseDTO;
import com.urcarcher.be.rani.VO.PlaceDTO;
import com.urcarcher.be.rani.repository.CourseRepository;
import com.urcarcher.be.rani.repository.PlaceRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	PlaceRepository placeRepo;
	
	@Override
	public List<CourseDTO> getCourseList(){
		List<CourseDTO> courseList = courseRepo.findAll().stream().map(c->entityToDTO(c))
				.collect(Collectors.toList());
		return courseList;
	}
	
	@Override
	public List<PlaceDTO> getPlaceList(String courseId){
		List<PlaceDTO> placeList = placeRepo.findByCourseId(courseId).stream().map(p->entityToDTO(p))
				.collect(Collectors.toList());
		return placeList;
	}
}
