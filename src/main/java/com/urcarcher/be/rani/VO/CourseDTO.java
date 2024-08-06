package com.urcarcher.be.rani.VO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CourseDTO {

	String courseId;
	String courseName;
	String region;
}
