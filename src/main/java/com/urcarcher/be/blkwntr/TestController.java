package com.urcarcher.be.blkwntr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/t")
public class TestController {
	
	@GetMapping("/test")
	String test() {
		return "In the bleak midwinter.";
	}
}
