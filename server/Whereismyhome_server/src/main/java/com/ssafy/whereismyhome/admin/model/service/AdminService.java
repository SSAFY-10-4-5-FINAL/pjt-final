package com.ssafy.whereismyhome.admin.model.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.admin.dto.request.RegisterUserDto;
import com.ssafy.whereismyhome.admin.dto.request.UpdateUserDto;
import com.ssafy.whereismyhome.admin.dto.response.GetUserDto;
import com.ssafy.whereismyhome.admin.model.mapper.AdminMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private AdminMapper adminMapper;

	public void addUser(RegisterUserDto registerUserDto) throws SQLException {
		adminMapper.addUser(registerUserDto);
		List<GetUserDto> getUserDtoList = adminMapper.getUsers();
		System.out.println(getUserDtoList);
	}
	
	public List<GetUserDto> getUsers() throws SQLException {
		System.out.println("hihi");
		List<GetUserDto> getUserDtoList = adminMapper.getUsers();
		
		return getUserDtoList;
	}

	public GetUserDto getUser(String userId) throws SQLException {
		GetUserDto getUserDto = adminMapper.getUser(userId);
		return getUserDto;
	}

	public GetUserDto searchUser(String userName) throws SQLException {
		GetUserDto getUserDto = adminMapper.searchUser(userName);
		return getUserDto;
	}

	public void updateUser(String userId, UpdateUserDto updateUserDto) throws SQLException {
		adminMapper.updateUser(userId, updateUserDto);
	}

	public void deleteUser(String userId) throws SQLException {
		adminMapper.deleteUser(userId);
	}

	
}
