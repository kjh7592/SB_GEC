package com.kjh.exam.gec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kjh.exam.gec.vo.Rq;

// 사용자가 보낸 요청이 컨트롤러에 직접 꽂히기 전에 한번 받은 모든 요청들을 받아서 처리한 후에 다시 컨트롤러에 보내주는 역할
@Component
public class BeforeActionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		
		Rq rq = new Rq(req, resp);
		req.setAttribute("rq", rq);
		
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}

	
}
