package com.urcarcher.be.syc98syc.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.blkwntr.auth.controller.AuthorizingController;
import com.urcarcher.be.blkwntr.auth.service.VanillaAuthorizingService;
import com.urcarcher.be.syc98syc.signup.dto.MemberDTO;
import com.urcarcher.be.syc98syc.signup.service.SignupService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {
	
	private final SignupService sService;
	
	@PostMapping("/local")
	public void signupForm(@RequestBody MemberDTO dto) {
		System.out.println(dto);
		sService.signupLocalMember(dto);
	}

}