package com.urcarcher.be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	@GetMapping("/start")
	public String start() {
		return "templates/start.html";
	}
}
