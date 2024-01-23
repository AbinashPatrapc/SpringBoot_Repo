package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckerHandler implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		System.out.println("TimeCheckerHandler.preHandle()");
		
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if(!req.getServletPath().equalsIgnoreCase("/")) {
		if (hour > 17 || hour < 9) {
			RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		}
		return true;
	}
}
