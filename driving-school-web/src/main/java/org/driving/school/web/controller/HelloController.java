package org.driving.school.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/webhello")
	public String hello(Model model){
		model.addAttribute("userName", "杨鹏程");
		return "/user/user";
	}
}
