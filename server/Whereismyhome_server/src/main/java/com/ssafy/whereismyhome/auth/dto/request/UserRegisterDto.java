package com.ssafy.whereismyhome.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
	
	private String name;
	private String userId;
	private String userPwd;
	private String userEmail;
	private String userBirth;
	private String userContact;
	
}
