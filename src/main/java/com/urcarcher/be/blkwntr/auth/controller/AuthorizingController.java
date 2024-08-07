package com.urcarcher.be.blkwntr.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.blkwntr.auth.MemberRole;
import com.urcarcher.be.blkwntr.auth.dto.LoginRequestDTO;
import com.urcarcher.be.blkwntr.auth.dto.TokenDTO;
import com.urcarcher.be.blkwntr.auth.service.VanillaAuthorizingService;
import com.urcarcher.be.blkwntr.entity.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthorizingController {
	private final VanillaAuthorizingService vanillaAuthorizingService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		String memberId = loginRequestDTO.getMemberId();
		String password = loginRequestDTO.getPassword();
		TokenDTO tokenDTO = vanillaAuthorizingService.loginChk(memberId, password);
		return ResponseEntity.ok(tokenDTO);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Member> signup(@RequestBody Member member) {
		member.setRole(MemberRole.USER);
		Member newMember = vanillaAuthorizingService.InsertAfterEncodingPw(member);
		return ResponseEntity.ok(newMember);
	}
}
