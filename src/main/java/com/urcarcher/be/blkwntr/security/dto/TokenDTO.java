package com.urcarcher.be.blkwntr.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenDTO {
	private String grantType; //jwt 인증 타입. Bearer 사용.
	private String accessToken;
	private String refreshToken;
}
