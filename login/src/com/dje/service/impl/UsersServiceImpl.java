package com.dje.service.impl;

import com.dje.mapper.UsersMapper;
import com.dje.pojo.Users;
import com.dje.service.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersMapper UsersMapper;
	
	public UsersMapper getUsersMapper() {
		return UsersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		UsersMapper = usersMapper;
	}

	@Override
	public Users login(Users users) {
		return UsersMapper.selAll(users);
	}

}
