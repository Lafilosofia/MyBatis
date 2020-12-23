package com.lhz.lhz_Spring_SSM01.login.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhz.lhz_Spring_SSM01.login.service.UserService;


/**
 * 控制层
 * @author HP
 *
 */

@Controller
@RequestMapping("user")
public class UserController extends HandlerExceptionMessage{
	//注入业务层
	@Autowired
	private UserService service;
	
	
	
	//登录页面
	@RequestMapping("login.do")
	public String loginHtml(){
		return "login";
	}
	
	@RequestMapping("toUserlogin.do")
	public String toUserLogin(String userName,@RequestParam("userPassword")String pwd){
		service.userLogin(userName, pwd);
		return "success";
	}
}
