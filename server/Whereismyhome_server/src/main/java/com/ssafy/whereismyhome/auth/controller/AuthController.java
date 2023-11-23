package com.ssafy.whereismyhome.auth.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.auth.dto.request.UserLoginDto;
import com.ssafy.whereismyhome.auth.dto.request.UserRegisterDto;
import com.ssafy.whereismyhome.auth.model.service.AuthService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UserLoginDto userLoginDto) throws IOException, SQLException {
		String message = authService.login(userLoginDto);
		if (!message.equals("success")) {
			new ResponseEntity(message, HttpStatus.UNAUTHORIZED);	// 401과 함께 message에 id 잘못인지 password 잘못인지 전달
		}
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity register(@RequestBody UserRegisterDto userRegisterDto) throws SQLException {
		authService.register(userRegisterDto);
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
