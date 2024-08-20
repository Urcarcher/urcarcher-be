package com.urcarcher.be.rani;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		
		List<PlaceDTO> places = courseService.getPlaceList(courseId);
	    ObjectMapper mapper = new ObjectMapper();
	    try {
	        String jsonResult = mapper.writeValueAsString(places);
	        System.out.println(jsonResult);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return places;
	    
//		System.out.println(courseService.getPlaceList(courseId).toString());
//		return courseService.getPlaceList(courseId);
	}
	
	@Value("${google.api.key}")
    private String googleApiKey;

    @PostMapping("/geolocation")
    public ResponseEntity<?> getGeolocation() {
        String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + googleApiKey;

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> body = new HashMap<>();
        body.put("considerIp", true);

        try {
            Map<String, Object> response = restTemplate.postForObject(url, body, Map.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving geolocation: " + e.getMessage());
        }
    }
    
}
