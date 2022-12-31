package com.kjh.exam.gec.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;

//@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Rq {
	@Getter
	private int loginedMemberId;

	public Rq(HttpServletRequest req) {

		HttpSession httpSession = req.getSession();

		int loginedMemberId = 0;

		if(httpSession.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}

		this.loginedMemberId = loginedMemberId;
	}

}
