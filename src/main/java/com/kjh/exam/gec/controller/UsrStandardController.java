package com.kjh.exam.gec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.exam.gec.service.StandardService;

@Controller
public class UsrStandardController {
	
	private StandardService standardService;
	
	@Autowired
	public UsrStandardController(StandardService standardService) {
		this.standardService = standardService;
	}

	@RequestMapping("/usr/standard/UpgradeStandard")
	public String showUpgradeStandard() {
		return "usr/standard/UpgradeStandard";
	}
	
	@RequestMapping("/usr/standard/doUpgradeStandard")
	@ResponseBody
	public String doUpgradeStandard() {
		return "";
	}
}
