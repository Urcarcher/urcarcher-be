package com.urcarcher.be.rani.VO;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="course_completion")
public class CourseCompletionEntity {
	
	@Id
	@Column(name="certification_id")
	private String certificationId;
	
	@Column(name="reward_id")
	private String rewardId;
	
	@Column (name="course_id")
	private String courseId;
	
	@Column(name="member_id")
	private String memberId;
	
	@Column(name="reward_status")
	private boolean rewardStatus;
	
	@CreationTimestamp
	@Column(name="completion_date")
	private Date completionDate;
	
	
}
