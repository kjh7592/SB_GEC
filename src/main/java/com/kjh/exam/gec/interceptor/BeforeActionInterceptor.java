package com.kjh.exam.gec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kjh.exam.gec.vo.Rq;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {

	private Rq rq;

	@Autowired
	public BeforeActionInterceptor(Rq rq) {
		this.rq = rq;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		
		rq.initOnBeforeActionInterceptor();
		
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}

	
}
