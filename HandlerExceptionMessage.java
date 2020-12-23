package com.lhz.lhz_Spring_SSM01.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import com.lhz.lhz_Spring_SSM01.login.service.UserPwdNotMatchedException;
import com.lhz.lhz_Spring_SSM01.login.service.nameNotExistException;


public abstract class HandlerExceptionMessage{
	//捕获异常信息
		@ExceptionHandler
		public String exceptionHandler(Exception exception ,HttpServletRequest request){
			if (exception instanceof UserPwdNotMatchedException ) {
				//绑定异常信息  获取异常信息
				request.setAttribute("message",exception.getMessage());
				return "login";
			}else if(exception instanceof nameNotExistException){
				//绑定异常信息  获取异常信息
				request.setAttribute("message2", exception.getMessage());
				return "login";
			}
			return "";
		}
}
