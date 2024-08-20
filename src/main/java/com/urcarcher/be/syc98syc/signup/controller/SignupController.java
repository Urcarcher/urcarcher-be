package com.urcarcher.be.syc98syc.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.blkwntr.auth.MemberProvider;
import com.urcarcher.be.blkwntr.auth.MemberRole;
import com.urcarcher.be.blkwntr.auth.controller.AuthorizingController;
import com.urcarcher.be.blkwntr.auth.service.VanillaAuthorizingService;
import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.syc98syc.signup.dto.MemberDTO;
import com.urcarcher.be.syc98syc.signup.service.SignupService;


import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/signup")
public class SignupController {
	
	private final SignupService sService;
	private final VanillaAuthorizingService vanillaAuthorizingService;
	
//	@PostMapping("/local")
//	public void signupForm(@RequestBody MemberDTO dto) {
//		System.out.println(dto);
//		sService.signupLocalMember(dto);
//	}
	@PostMapping("/local")
	public ResponseEntity<Member> signup(@RequestBody Member member) {
		member.setRole(MemberRole.USER);
		member.setPoint(0);
		member.setProvider(MemberProvider.URCARCHER);
		Member newMember = vanillaAuthorizingService.InsertAfterEncodingPw(member);
		return ResponseEntity.ok(newMember);
	}
	
	@GetMapping("/idDupCheck")
	public ResponseEntity<?> idDupCheck(@RequestParam("memberId") String memId) {
		boolean exists = sService.idDupCheck(memId);
		return ResponseEntity.ok().body(exists);
	}
	

}