package com.ssafy.whereismyhome.admin.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.admin.dto.request.RegisterUserDto;
import com.ssafy.whereismyhome.admin.dto.request.UpdateUserDto;
import com.ssafy.whereismyhome.admin.dto.response.GetUserDto;
import com.ssafy.whereismyhome.admin.model.service.AdminService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	private AdminService adminService;
	
	@GetMapping("/user")
	public ResponseEntity getUsers() throws SQLException {
		List<GetUserDto> getUserDtoList = adminService.getUsers();
		
		return new ResponseEntity(getUserDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity getUser(@PathVariable String userId) throws SQLException {
		GetUserDto getUserDto = adminService.getUser(userId);
		
		return new ResponseEntity(getUserDto, HttpStatus.OK);
	}
	
	@GetMapping("/user/search")
	public ResponseEntity searchUser(@RequestParam String userName) throws SQLException {
		GetUserDto getUserDto = adminService.searchUser(userName);
		
		return new ResponseEntity(getUserDto, HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity updateUser(@PathVariable String userId, @RequestBody UpdateUserDto updateUserDto) throws SQLException {
		adminService.updateUser(userId, updateUserDto);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) throws SQLException {
		adminService.deleteUser(userId);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
