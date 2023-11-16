package com.ssafy.whereismyhome.auth.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.whereismyhome.auth.dto.request.UserRegisterDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static String BASE_URL = "http://localhost:8080";
	
	@PostMapping("/login")
	public void login(HttpSession session, HttpServletResponse res) throws IOException {
		
		String redirect_uri = BASE_URL;	// 로그인 완료 후 메인 페이지로 redirect
		res.sendRedirect(redirect_uri);
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auth/login");
		return mav;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserRegisterDto userRegisterDto) {
		
		
		return "temp";
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auth/register");
		
		return mav;
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse res) throws IOException {
		session.invalidate();
		String redirect_uri = BASE_URL;
		res.sendRedirect(redirect_uri);
	}
	
}
