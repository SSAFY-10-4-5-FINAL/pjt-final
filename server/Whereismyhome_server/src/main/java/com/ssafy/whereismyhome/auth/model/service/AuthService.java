package com.ssafy.whereismyhome.auth.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.dto.response.DealInfoDto;
import com.ssafy.whereismyhome.apart.dto.response.DongDto;
import com.ssafy.whereismyhome.apart.model.mapper.ApartMapper;
import com.ssafy.whereismyhome.auth.dto.UserDto;
import com.ssafy.whereismyhome.auth.dto.request.UserLoginDto;
import com.ssafy.whereismyhome.auth.dto.request.UserRegisterDto;
import com.ssafy.whereismyhome.auth.model.mapper.AuthMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
	
	private final AuthMapper authMapper;

	public String login(UserLoginDto userLoginDto) throws SQLException {
		UserDto loginUser = authMapper.login(userLoginDto.getLoginId());
		if (loginUser == null) {
			return "id";
		}
		if (!loginUser.getPassword().equals(userLoginDto.getPassword())) {
			return "password";
		}
		
		return "success";
	}

	public void register(UserRegisterDto userRegisterDto) throws SQLException {
		authMapper.register(userRegisterDto);
	}
	
}
