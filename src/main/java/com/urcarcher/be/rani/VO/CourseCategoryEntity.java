package com.urcarcher.be.rani.VO;

import java.sql.Date;

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
@Table(name="course_category")
public class CourseCategoryEntity {

	@Id
	@Column (name="course_id")
	private String courseId;
	
	@Column (name="course_name")
	private String courseName;
	
	@Column (name="course_count")
	private int courseCount;
	
	@Column (name="point_amount")
	private int pointAmount;
	
	@Column (name="region")
	private String region;
	
}
