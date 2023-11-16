package com.ssafy.whereismyhome.admin.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.admin.dto.request.RegisterUserDto;
import com.ssafy.whereismyhome.admin.dto.request.UpdateUserDto;
import com.ssafy.whereismyhome.admin.dto.response.GetUserDto;
import com.ssafy.whereismyhome.admin.model.service.AdminService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	private AdminService adminService;
	
	@PostMapping("/user")
	public void addUser(@RequestBody RegisterUserDto registerUserDto) throws SQLException {
		adminService.addUser(registerUserDto);
	}
	
	@GetMapping("/user")
	public List<GetUserDto> getUsers() throws SQLException {
		List<GetUserDto> getUserDtoList = adminService.getUsers();
		
		return getUserDtoList;
	}
	
	@GetMapping("/user/{userId}")
	public GetUserDto getUser(@PathVariable String userId) throws SQLException {
		GetUserDto getUserDto = adminService.getUser(userId);
		
		return getUserDto;
	}
	
	@GetMapping("/user/search")
	public GetUserDto searchUser(@RequestParam String userName) throws SQLException {
		GetUserDto getUserDto = adminService.searchUser(userName);
		
		return getUserDto;
	}
	
	@PutMapping("/user/{userId}")
	public void updateUser(@PathVariable String userId, @RequestBody UpdateUserDto updateUserDto) throws SQLException {
		adminService.updateUser(userId, updateUserDto);
	}
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable String userId) throws SQLException {
		adminService.deleteUser(userId);
	}
	
}
