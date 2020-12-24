package com.lhz.lhz_Spring_SSM01.login.mapper;

import com.lhz.lhz_Spring_SSM01.login.entity.User;

/**
 * 映射器
 * @author HP
 *
 */
public interface UserMapper {
	//根据用户名查询用户数据
	User findUserByName(String name);
}
