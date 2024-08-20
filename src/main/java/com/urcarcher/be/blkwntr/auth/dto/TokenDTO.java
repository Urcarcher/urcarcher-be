<<<<<<< HEAD:src/main/java/com/urcarcher/be/blkwntr/security/dto/TokenDTO.java
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
=======
package com.urcarcher.be.blkwntr.auth.dto;

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
>>>>>>> e0976b33df46727ffa61c1363548f8ec5366ba5f:src/main/java/com/urcarcher/be/blkwntr/auth/dto/TokenDTO.java
