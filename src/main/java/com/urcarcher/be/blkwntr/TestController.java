package com.urcarcher.be.blkwntr;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.blkwntr.auth.service.VanillaAuthorizingService;
import com.urcarcher.be.blkwntr.entity.Member;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/t")
@RequiredArgsConstructor
public class TestController {
	
	private final VanillaAuthorizingService vanillaAuthorizingService;
	
	@GetMapping("/test")
	Member test(@AuthenticationPrincipal UserDetails userDetails) {
		return vanillaAuthorizingService.getMemberByAuth(userDetails);
	}
}
