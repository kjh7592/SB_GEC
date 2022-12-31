package com.kjh.exam.gec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UsrHomeController {
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String showMain() {
		return "안녕하세요";
	}
	
//	@RequestMapping("/usr/home/main")
//	public String showMain() {
//		return "usr/home/main";
//	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
}
