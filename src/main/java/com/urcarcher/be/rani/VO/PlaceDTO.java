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
public class PlaceDTO {

	String placeId;
	String placeName;
	String address;
	BigDecimal latitude;
	BigDecimal longitude;
	String content;
	String detailContent;
	String placeImg;
}
