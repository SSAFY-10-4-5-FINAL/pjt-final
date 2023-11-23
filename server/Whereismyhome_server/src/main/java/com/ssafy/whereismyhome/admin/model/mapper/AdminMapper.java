package com.ssafy.whereismyhome.admin.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.admin.dto.request.RegisterUserDto;
import com.ssafy.whereismyhome.admin.dto.request.UpdateUserDto;
import com.ssafy.whereismyhome.admin.dto.response.GetUserDto;

@Mapper
public interface AdminMapper {
	
	
	List<GetUserDto> getUsers() throws SQLException;
	GetUserDto getUser(String userId) throws SQLException;
	GetUserDto searchUser(String userName) throws SQLException;
	void updateUser(String userId, UpdateUserDto updateUserDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;

}
