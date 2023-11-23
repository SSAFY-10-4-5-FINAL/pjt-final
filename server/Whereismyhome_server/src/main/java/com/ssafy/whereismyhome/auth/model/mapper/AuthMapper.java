package com.ssafy.whereismyhome.auth.model.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.auth.dto.UserDto;
import com.ssafy.whereismyhome.auth.dto.request.UserLoginDto;
import com.ssafy.whereismyhome.auth.dto.request.UserRegisterDto;


@Mapper
public interface AuthMapper {
	
	UserDto login(String loginId) throws SQLException;
	void register(UserRegisterDto userRegisterDto) throws SQLException;
	
}
