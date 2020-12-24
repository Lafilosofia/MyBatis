package com.lhz.lhz_Spring_SSM01.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhz.lhz_Spring_SSM01.login.entity.User;
import com.lhz.lhz_Spring_SSM01.login.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	//注入持久层
	@Autowired
	private UserMapper mapper;
	//用户登录
	@Override
	public User userLogin(String name, String pwd) {
		//根据用户名字查询是否存在该用户
		User user = mapper.findUserByName(name);
		if (user == null) {
			throw new nameNotExistException("此用户不存在!");
		}
		//获取该用户在数据库中的密码
		String dbpwd = user.getUserPwd();
		//判断用户输入的密码和数据库中的密码是否一样
		if (!dbpwd.equals(pwd)) {
			throw new UserPwdNotMatchedException("用户密码错误");
		}
		//登陆成功
		return user;
	}

}
