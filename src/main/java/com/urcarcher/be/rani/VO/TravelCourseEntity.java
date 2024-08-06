package com.urcarcher.be.rani.VO;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(name="travel_course")
public class TravelCourseEntity {
	
	@Id
	@Column(name = "place_id")
	private String placeId;
	
	@Column (name="course_id")
	private String courseId;
	
	@Column(name = "place_name")
	private String placeName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "latitude")
	private BigDecimal latitude;
	
	@Column(name = "longitude")
	private BigDecimal longitude;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "detail_content")
	private String detailContent;
	
	@Column(name = "place_img")
	private String placeImg;
	
}
