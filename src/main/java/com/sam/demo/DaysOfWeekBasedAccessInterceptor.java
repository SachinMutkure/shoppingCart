package com.sam.demo;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DaysOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			 Object handler) throws IOException{
		
		Calendar cal = Calendar.getInstance();
		int dayOfweek = cal.get(cal.DAY_OF_WEEK);
		
		if(dayOfweek == 1){
			response.getWriter().write("The website is close on Wednesday, Please try accesing in "
					+ "on any other week days!!");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			 Object handler,ModelAndView modelAndView)throws Exception{
		
		System.out.println("HandlerInteceptorAdapter:Spring MVC call postHandler method for "
								+request.getRequestURI().toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			 Object handler,Exception ex) throws Exception{
		System.out.println("HandlerInteceptorAdapter:Spring MVC call afterCompletion method for "
				+request.getRequestURI().toString());
	}
}
