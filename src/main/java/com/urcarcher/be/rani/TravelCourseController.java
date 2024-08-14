package com.urcarcher.be.rani;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.rani.VO.CourseDTO;
import com.urcarcher.be.rani.VO.PlaceDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class TravelCourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/list")
	List<CourseDTO> courseList(){
		return courseService.getCourseList();
	}
	
	@GetMapping("/{courseId}")
	List<PlaceDTO> placeList(@PathVariable("courseId") String courseId){
		System.out.println(courseService.getPlaceList(courseId).toString());
		return courseService.getPlaceList(courseId);
	}
	
}
